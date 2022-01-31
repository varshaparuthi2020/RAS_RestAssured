package pojo;

public class AddAccountDto {

	private AddAccountPayload accountDto;

	public AddAccountPayload getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AddAccountPayload accountDto) {
		this.accountDto = accountDto;
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

	private String statusCode;
	private String message;
	
	
}
