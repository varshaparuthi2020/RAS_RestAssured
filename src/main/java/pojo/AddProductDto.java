package pojo;

public class AddProductDto {




	public AddProductPayload getProductDto() {
		return productDto;
	
	}

	public void setProductDto(AddProductPayload productDto) {
		this.productDto = productDto;
	}

	private  AddProductPayload productDto;
	
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
