package Resources;

import java.util.ArrayList;
import java.util.List;

import StepDefinitions.NewAccount;
import pojo.AddAccountDto;
import pojo.AddAccountPayload;
import pojo.AddProductDto;
import pojo.AddProductPayload;
import pojo.AddTransactionDto;
import pojo.ProductClientDto;
import pojo.ProductConfigDto;
import pojo.TransactionDetail;
import pojo.TransactionPayload;
import pojo.UpdateAccount;

public class TestDataBuild {
	AddProductDto ad = new AddProductDto();
	AddProductPayload pdt = new AddProductPayload();
	AddAccountDto aad;
	AddAccountPayload aap;
	UpdateAccount ua ;
	AddTransactionDto at;
	TransactionPayload tp;
	
	//public AddProductDto createProductPayload() {
		
	public AddProductDto createProductPayload(String productName,String status , String description) {		
				ad.setProductDto(pdt);
		// System.out.print(ad.setProductDto(pdt));
		pdt.setProductName(productName);
		pdt.setDescription(description);
		//pdt.setDescription("Prod description Hell022Nov");
		//pdt.setProductName("22Nov");
		pdt.setAccountingType("DOUBLE");
		pdt.setCurrency("EUR");
		//pdt.setStatus("Active");
		pdt.setStatus(status);
		pdt.setCreatedBy("Vrsha");
		pdt.setUom("NUMBER");

		ProductClientDto pcl = new ProductClientDto();
		List<ProductClientDto> lp = new ArrayList<ProductClientDto>();
		lp.add(pcl);
		pcl.setClientId("1001");
		pdt.setProductClientDtoList(lp);
		
		ProductConfigDto pcd = new ProductConfigDto();
		List<ProductConfigDto> ls = new ArrayList<ProductConfigDto>();
		ls.add(pcd);
		pcd.setConfigName("MAX_ALLOWED_AMOUNT");
		pcd.setConfigValue("500");
		pcd.setCreatedBy("vr");
		pcd.setStatus("Active");
		pdt.setProductConfigDtoList(ls);		
		return ad;
	}
	
	public int addProductId() {
		AddProductDto ad = new AddProductDto();
		AddProductPayload pdt = new AddProductPayload();
		return pdt.getProductId();

		
	}
	
	public String updateConfig() {
		
		return "{\n"
				+ "\"productId\": \"+ad.getProductDto().getProductId()+\",\n"
				+ "\"productName\": \"+ad.getProductDto().getProductName()\",\n"
				+ "\"productConfigDtoList\": [\n"
				+ "{\n"
				+ "\"configName\": \"Rate_Limit\",\n"
				+ "\"configValue\": \"1001\",\n"
				+ "\"status\": \"ACTIVE\",\n"
				+ "\"createdBy\": \"Seema\"\n"
				+ "},\n"
				+ "{\n"
				+ "\"configName\": \"ALLOW_NEGATIVE_BALANCE\",\n"
				+ "\"configValue\": \"700\",\n"
				+ "\"status\": \"INACTIVE\",\n"
				+ "\"createdBy\": \"Varsha\"\n"
				+ "}\n"
				+ "]\n"
				+ "   }";
	}

public AddAccountDto addaccountdata(int productId,String accountType,String accountNumber) {
	
	aad= new AddAccountDto();
	
	aap = new AddAccountPayload();
	aap.setAccountName("VRRAni");
	aap.setAccountNumber(accountNumber);
	aap.setAccountType(accountType);
	aap.setCreatedBy("Vrsha");
	aap.setDescription("LoanAccount desc");
	aap.setStatus("ACTIVE");
	aap.setProductId(productId);
	aad.setAccountDto(aap);
	
	return aad;
	
	
}
public UpdateAccount payloadUpdateAccount() {
	ua = new UpdateAccount();
	ua.setAccountId(NewAccount.aid);
	ua.setAccountNumber("");
	ua.setProductId(0);
	ua.setStatus("INACTIVE");
	ua.setUpdatedBy("Neeraj");
	
	return ua;
	
	
}

public AddTransactionDto addTransaction(Integer fromAccountId, Integer toAccountId , Integer productId , Integer amount) {
	at = new AddTransactionDto();
	tp = new TransactionPayload();
	at.setTransactionDto(tp);
	tp.setProductTransaction("AutoPayu");
	tp.setFromAccountId(fromAccountId);
	tp.setToAccountId(toAccountId);
	tp.setAmount(amount);
	tp.setTransactionType("Credit");
	tp.setTransactionNarration("First pool transaction");
	tp.setProductId(productId);
	tp.setTransactionDate("2021-11-25 00:00:00");
	tp.setTransactionMode("NEFT");
	tp.setCreatedBy("nane");
	
	TransactionDetail td = new TransactionDetail();
	List<TransactionDetail> l = new ArrayList<TransactionDetail>();
	td.setPgVendor("heyvr");
	td.setOther("nA");
	l.add(td);
	tp.setTransactionDetailList(l);
		
	return at;

}

public AddTransactionDto addTransactionBalance(Integer toAccountId , Integer productId , Integer amount) {
	at = new AddTransactionDto();
	tp = new TransactionPayload();
	at.setTransactionDto(tp);
	tp.setProductTransaction("AutoPayu1");
    tp.setToAccountId(toAccountId);
	tp.setAmount(amount);
	tp.setTransactionType("Credit");
	tp.setTransactionNarration("First pool transaction");
	tp.setProductId(productId);
	tp.setTransactionDate("2021-11-26 00:00:00");
	tp.setTransactionMode("NEFT");
	tp.setCreatedBy("nane");
	
	TransactionDetail td = new TransactionDetail();
	List<TransactionDetail> l = new ArrayList<TransactionDetail>();
	td.setPgVendor("heyvr");
	td.setOther("nA");
	l.add(td);
	tp.setTransactionDetailList(l);
		
	return at;

}

}
