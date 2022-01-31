package Resources;

public enum APIResources {
	
	
	AddProductAPI("/products/addProduct"),
	GetProductsAPI("/products"),
	GetProductAPI("/products/productId/"),
	UpdateProductAPI("/products/updateProduct"),
	UpdateProductConfigAPI("/products/config"),
	AddAccountAPI("/accounts/addAccount"),
	GetAccountsAPI("/accounts"),
	UpdateAccountAPI("/accounts/updateStatus"),
	GetAccountAPI("/accounts/accountNumber/"),
	AddTransactionAPI("transaction"),
	GetBalanceAPI("/accounts/getBalance"),
	GetLedgerAPI("/ledger");
	private String resource;
	
	APIResources(String resource){
		
		this.resource = resource;
		
	}
	 public String getResource() {
		 
		 return resource;
	 }
	

}
