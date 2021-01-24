package com.bring.digital.transaction.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bring.digital.transaction.domain.Backbase;
import com.bring.digital.transaction.domain.Backbase.BackbaseBuilder;
import com.bring.digital.transaction.dto.OpenBankDataDTO;
import com.bring.digital.transaction.dto.Transaction;
import com.bring.digital.transaction.lib.service.BringService;
import com.bring.digital.transaction.openbank.service.OpenBankService;

@Service
public class TransactionOpenBankService extends BringService<Backbase> {

	private static final Logger logger = Logger.getLogger(BringService.class);

	@Autowired
	private OpenBankService openBankService;

	public List<Backbase> all() {

		logger.info("Find all transaction");

		return this.getTransactionFromAPI();
	}

	@Override
	public List<Backbase> findByTypeTransaction(String type) {

		List<Backbase> backbases = this.getTransactionFromAPI();

		List<Backbase> filterBackbaseList = backbases.stream().filter(item -> item.getTransactionType().equals(type))
				.collect(Collectors.toList());

		return filterBackbaseList;
	}

	private List<Backbase> getTransactionFromAPI() {
		logger.info("getTransactionFromAPI");

		OpenBankDataDTO openBankDataDTO = openBankService.getAllTransactions();

		logger.debug("OpenBankDataDTO object: " + openBankDataDTO.toString());

		List<Backbase> banks = new ArrayList<Backbase>();

		if (openBankDataDTO == null)
			return banks;

		openBankDataDTO.getTransactions().forEach(transaction -> this.buildBank(transaction, banks));

		logger.debug("List of Banks: " + banks.size());

		return banks;

	}

	private void buildBank(Transaction transaction, List<Backbase> banks) {

		logger.info("Building a list of Backbase object");

		BackbaseBuilder backbaseBuilder = new BackbaseBuilder();

		Backbase backbase = backbaseBuilder.id(transaction.getId()).accountId(transaction.getThisAccount().getId())
				.counterpartyAccount(transaction.getOtherAccount().getNumber())
				.counterpartyName(transaction.getOtherAccount().getHolder().getName())
				.counterPartyLogoPath(transaction.getOtherAccount().getMetadata().getImageURL())
				.instructedCurrency(transaction.getDetails().getValue().getCurrency())
				.instructedAmount(transaction.getDetails().getValue().getAmount())
				.transactionAmount(transaction.getDetails().getValue().getAmount())
				.transactionCurrency(transaction.getDetails().getValue().getCurrency())
				.transactionType(transaction.getDetails().getType())
				.description(transaction.getDetails().getDescription()).build();

		banks.add(backbase);

	}

}
