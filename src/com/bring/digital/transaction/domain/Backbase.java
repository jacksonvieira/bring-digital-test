package com.bring.digital.transaction.domain;

import java.io.Serializable;

public class Backbase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String accountId;

	private String counterpartyAccount;

	private String counterpartyName;

	private Object counterPartyLogoPath;

	private Double instructedAmount;

	private String instructedCurrency;

	private Double transactionAmount;

	private String transactionCurrency;

	private String transactionType;

	private String description;

	public Backbase() {

	}

	public Backbase(BackbaseBuilder builder) {
		this.id = builder.id;

		this.accountId = builder.accountId;

		this.counterpartyAccount = builder.counterpartyAccount;

		this.counterpartyName = builder.counterpartyName;

		this.counterPartyLogoPath = builder.counterPartyLogoPath;

		this.instructedAmount = builder.instructedAmount;

		this.instructedCurrency = builder.instructedCurrency;

		this.transactionAmount = builder.transactionAmount;

		this.transactionCurrency = builder.transactionCurrency;

		this.transactionType = builder.transactionType;

		this.description = builder.description;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCounterpartyAccount() {
		return counterpartyAccount;
	}

	public void setCounterpartyAccount(String counterpartyAccount) {
		this.counterpartyAccount = counterpartyAccount;
	}

	public String getCounterpartyName() {
		return counterpartyName;
	}

	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}

	public Object getCounterPartyLogoPath() {
		return counterPartyLogoPath;
	}

	public void setCounterPartyLogoPath(Object counterPartyLogoPath) {
		this.counterPartyLogoPath = counterPartyLogoPath;
	}

	public Double getInstructedAmount() {
		return instructedAmount;
	}

	public void setInstructedAmount(Double instructedAmount) {
		this.instructedAmount = instructedAmount;
	}

	public String getInstructedCurrency() {
		return instructedCurrency;
	}

	public void setInstructedCurrency(String instructedCurrency) {
		this.instructedCurrency = instructedCurrency;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static class BackbaseBuilder {
		private String id;
		private String accountId;
		private String counterpartyAccount;
		private String counterpartyName;
		private Object counterPartyLogoPath;
		private Double instructedAmount;
		private String instructedCurrency;
		private Double transactionAmount;
		private String transactionCurrency;
		private String transactionType;
		private String description;

		public BackbaseBuilder id(String id) {
			this.id = id;
			return this;
		}

		public BackbaseBuilder accountId(String accountId) {
			this.accountId = accountId;
			return this;
		}

		public BackbaseBuilder counterpartyAccount(String counterpartyAccount) {
			this.counterpartyAccount = counterpartyAccount;
			return this;
		}

		public BackbaseBuilder counterpartyName(String counterpartyName) {
			this.counterpartyName = counterpartyName;
			return this;
		}

		public BackbaseBuilder counterPartyLogoPath(Object counterPartyLogoPath) {
			this.counterPartyLogoPath = counterPartyLogoPath;
			return this;
		}

		public BackbaseBuilder instructedAmount(String instructedAmount) {
			Double value = Double.parseDouble(instructedAmount.replace(",", "."));
			this.instructedAmount = value;
			return this;
		}

		public BackbaseBuilder instructedCurrency(String instructedCurrency) {
			this.instructedCurrency = instructedCurrency;
			return this;
		}

		public BackbaseBuilder transactionAmount(String transactionAmount) {
			Double value = Double.parseDouble(transactionAmount.replace(",", "."));
			this.transactionAmount = value;
			return this;
		}

		public BackbaseBuilder transactionCurrency(String transactionCurrency) {
			this.transactionCurrency = transactionCurrency;
			return this;
		}

		public BackbaseBuilder transactionType(String transactionType) {
			this.transactionType = transactionType;
			return this;
		}

		public BackbaseBuilder description(String description) {
			this.description = description;
			return this;
		}

		public Backbase build() {
			return new Backbase(this);
		}

	}

}
