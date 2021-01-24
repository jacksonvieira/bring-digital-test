package com.bring.digital.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bring.digital.transaction.domain.Backbase;
import com.bring.digital.transaction.lib.service.BringException;
import com.bring.digital.transaction.service.TransactionOpenBankService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionOpenBankController {

	@Autowired
	private TransactionOpenBankService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Backbase>> getTransactions() throws BringException {

		List<Backbase> banks = service.all();

		if (banks == null)
			return new ResponseEntity<List<Backbase>>((List<Backbase>) null, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Backbase>>(banks, HttpStatus.OK);

	}

	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<Backbase>> getTransactionByType(@PathVariable("type") String typeTransaction)
			throws BringException {

		List<Backbase> backbases = service.findByTypeTransaction(typeTransaction);

		if (backbases == null)
			return new ResponseEntity<List<Backbase>>((List<Backbase>) null, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Backbase>>(backbases, HttpStatus.OK);
	}
	
	

}
