package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ProductDto {

	
	//@JsonFormat(with = Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	//@JsonDeserialize(using = JsonDeserializer.class)

	private  ProductPayload productDto;
	private String statusCode;
	private String message;
	
	public ProductPayload getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductPayload productDto) {
		this.productDto = productDto;
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
	
}
