package pojo;

import java.util.List;

public class TransactionPayload {

	
	public String getProductTransaction() {
		return productTransaction;
	}
	public void setProductTransaction(String productTransaction) {
		this.productTransaction = productTransaction;
	}
	public Integer getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(Integer fromAccountId2) {
		this.fromAccountId = fromAccountId2;
	}
	public int getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionNarration() {
		return transactionNarration;
	}
	public void setTransactionNarration(String transactionNarration) {
		this.transactionNarration = transactionNarration;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<TransactionDetail> getTransactionDetailList() {
		return transactionDetailList;
	}
	public void setTransactionDetailList(List<TransactionDetail> transactionDetailList) {
		this.transactionDetailList = transactionDetailList;
	}
	private String productTransaction;
	
	private Integer fromAccountId;
	private int toAccountId;
	private int amount;
	private String transactionType;
	private String transactionNarration;
	private String transactionDate;
	private String transactionMode;
	private String createdBy;
	private List<TransactionDetail> transactionDetailList;
	
	private int transactionId;
	public int getProductClientId() {
		return productClientId;
	}
	public void setProductClientId(int productClientId) {
		this.productClientId = productClientId;
	}
	private int productClientId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	private int productId;

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
