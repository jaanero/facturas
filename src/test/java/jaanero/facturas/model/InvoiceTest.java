package jaanero.facturas.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InvoiceTest {
	
	private static final float DELTA = 0.001f;

	private static final Long INVOICE_ID = Long.valueOf(1);
	private static final float INVOICE_AMOUNT = 100F;
	private static final String INVOICE_CONCEPT = "Una sesión de cuentos a cargo de X";
	private static final Date INVOICE_DATE = new Date();
	private static final int INVOICE_NUMBER = 2;
	private static final boolean INVOICE_QUOTE = false;
	private static final boolean INVOICE_ISSUED = false;
	private static final float INVOICE_VAT = 0.07f;
	private static final float INVOICE_RENT = 0.21f;
	
	public static Invoice INVOICE = new Invoice(ClientTest.CLIENT,INVOICE_AMOUNT);
	
	static {
		INVOICE.setConcept(INVOICE_CONCEPT);
		INVOICE.setDate(INVOICE_DATE);
		INVOICE.setInvoiceNumber(INVOICE_NUMBER);
		INVOICE.setNote(NoteTest.NOTE);
		INVOICE.setQuote(INVOICE_QUOTE);
		INVOICE.setRentRate(INVOICE_RENT);
		INVOICE.setVatRate(INVOICE_VAT);
		INVOICE.setIssued(INVOICE_ISSUED);
	}
	
	private Invoice invoice;
	
	@Before 
	public void init(){
		invoice = new Invoice(ClientTest.CLIENT,INVOICE_AMOUNT);
		invoice.setConcept(INVOICE_CONCEPT);
		invoice.setDate(INVOICE_DATE);
		invoice.setInvoiceNumber(INVOICE_NUMBER);
		invoice.setNote(NoteTest.NOTE);
		invoice.setQuote(INVOICE_QUOTE);
		invoice.setRentRate(INVOICE_RENT);
		invoice.setVatRate(INVOICE_VAT);
		invoice.setIssued(INVOICE_ISSUED);
	}
	
	@Test
	public void should_create_an_invoice_and_populate_it(){
		Invoice invoice = new Invoice(ClientTest.CLIENT,INVOICE_AMOUNT);
		Assert.assertEquals(invoice.getBase(), INVOICE_AMOUNT,0.0001F);
		Assert.assertEquals(invoice.getClient(), ClientTest.CLIENT);
	}
	
	@Test
	public void should_be_able_to_modify_invoice(){

		invoice.setClient(ClientTest.ANOTHER_CLIENT);
		invoice.setBase(INVOICE_AMOUNT+100F);
		invoice.setId(INVOICE_ID);

		Assert.assertEquals(invoice.getId(), INVOICE_ID);
		Assert.assertEquals(invoice.getBase(), INVOICE_AMOUNT+100F,DELTA);
		Assert.assertEquals(invoice.getClient(), ClientTest.ANOTHER_CLIENT);
		Assert.assertEquals(invoice.getConcept(), INVOICE_CONCEPT);
		Assert.assertEquals(invoice.getVatRate(), INVOICE_VAT, DELTA);
		Assert.assertEquals(invoice.getDate(), INVOICE_DATE);
		Assert.assertEquals(invoice.getInvoiceNumber(), INVOICE_NUMBER);
		Assert.assertEquals(invoice.getNote(), NoteTest.NOTE);
		Assert.assertEquals(invoice.getRentRate(), INVOICE_RENT, DELTA);
		Assert.assertEquals(invoice.isIssued(), INVOICE_ISSUED);
		Assert.assertEquals(invoice.isQuote(), INVOICE_QUOTE);
	
	}
	
	@Test
	public void should_set_number_to_zero_when_invoice_is_quote(){

	}
	
	@Test
	public void should_throw_exception_when_trying_to_change_issued_invoice(){
		
	}
	
}
