package com.bring.digital.transaction.openbank.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bring.digital.transaction.dto.OpenBankDataDTO;

@Service
public class OpenBankService {

	@Value("${bring.api.url}") String urlAPI;
	
	public OpenBankDataDTO getAllTransactions() {

		RestTemplate rest = new RestTemplate();

		return rest.getForObject(urlAPI, OpenBankDataDTO.class);
	}
}
