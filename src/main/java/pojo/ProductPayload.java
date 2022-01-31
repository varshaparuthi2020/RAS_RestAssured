package pojo;

import java.util.List;

public class ProductPayload {

	private int productId;
	private String productName;
	private String description;
	private String accountingType;
	private String status;
	private String currency;
	private String createdBy;
	private List<ProductClientDto> productClientDtoList;
	private List<ProductConfigDto> productConfigDtoList;
	private String uom;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccountingType() {
		return accountingType;
	}

	public void setAccountingType(String accountingType) {
		this.accountingType = accountingType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<ProductClientDto> getProductClientDtoList() {
		return productClientDtoList;
	}

	public void setProductClientDtoList(List<ProductClientDto> productClientDtoList) {
		this.productClientDtoList = productClientDtoList;
	}

	public List<ProductConfigDto> getProductConfigDtoList() {
		return productConfigDtoList;
	}

	public void setProductConfigDtoList(List<ProductConfigDto> productConfigDtoList) {
		this.productConfigDtoList = productConfigDtoList;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}
}