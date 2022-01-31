package pojo;

public class AddTransactionDto {

	
	public TransactionPayload getTransactionDto() {
		return transactionDto;
	}
	public void setTransactionDto(TransactionPayload transactionDto) {
		this.transactionDto = transactionDto;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private TransactionPayload transactionDto;
	
	private String statusCode;
	private String message;
}
