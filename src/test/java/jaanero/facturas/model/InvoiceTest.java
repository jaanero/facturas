package jaanero.facturas.model;

import org.junit.Test;

import junit.framework.Assert;

public class InvoiceTest {

	public static float INVOICE_AMOUNT = 100F;
	public static Invoice INVOICE = new Invoice(ClientTest.CLIENT,INVOICE_AMOUNT);
	
	@Test
	public void should_create_an_invoice_and_populate_it(){
		Invoice invoice = new Invoice(ClientTest.CLIENT,INVOICE_AMOUNT);
		Assert.assertEquals(invoice.getBase(), INVOICE_AMOUNT);
		Assert.assertEquals(invoice.getClient(), ClientTest.CLIENT);
	}
	
	@Test
	public void should_be_able_to_modify_invoice(){
		Invoice invoice = new Invoice(ClientTest.CLIENT,INVOICE_AMOUNT);
		invoice.setClient(ClientTest.ANOTHER_CLIENT);
		invoice.setBase(INVOICE_AMOUNT+100F);
		
		Assert.assertEquals(invoice.getBase(), INVOICE_AMOUNT+100F);
		Assert.assertEquals(invoice.getClient(), ClientTest.ANOTHER_CLIENT);
	}
	
}
