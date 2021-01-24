package com.bring.digital.transaction.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "transactions" })
public class OpenBankDataDTO implements Serializable {

	@JsonProperty("transactions")
	private List<Transaction> transactions = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 5545964921416941685L;

	@JsonProperty("transactions")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	@JsonProperty("transactions")
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "OpenBankDataDTO [transactions=" + transactions + ", additionalProperties=" + additionalProperties + "]";
	}

}
