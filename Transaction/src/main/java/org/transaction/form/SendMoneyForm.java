package org.transaction.form;

public class SendMoneyForm {

	private Long fromAccountId;
	private Long toAccountId;
	private double amount;
	
	public SendMoneyForm() {
	}

	public SendMoneyForm(Long fromAccountId, Long toAccountId, double amount) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}

	public Long getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
