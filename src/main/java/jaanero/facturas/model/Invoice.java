package jaanero.facturas.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "INVOICE_KEY")
   private Long id;
   @Column(name = "INVOICE_NUMBER")
   private int number;
   @Column(name = "INVOICE_DATE")
   private Date date;
   @Column(name = "INVOICE_CONCEPT")
   private String concept;
   @Column(name = "INVOICE_BASE")
   private float base;
   @Column(name = "INVOICE_VAT")
   private float vatRate;
   @Column(name = "INVOICE_RENT")
   private float rentRate;
   @Column(name = "INVOICE_QUOTE")
   private boolean quote;
   @Column(name = "INVOICE_ISSUED")
   private boolean issued;

   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "CLIENT_KEY")
   private Client client;

   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "NOTE_KEY")
   private Note note;

   public Invoice(Client client, float base) {
      super();
      this.setClient(client);
      this.setBase(base);
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public int getInvoiceNumber() {
      return number;
   }

   public void setInvoiceNumber(int number) {
      this.number = number;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public String getConcept() {
      return concept;
   }

   public void setConcept(String concept) {
      this.concept = concept;
   }

   public float getVatRate() {
      return vatRate;
   }

   public void setVatRate(float vatRate) {
      this.vatRate = vatRate;
   }

   public float getRentRate() {
      return rentRate;
   }

   public void setRentRate(float rentRate) {
      this.rentRate = rentRate;
   }

   public boolean isQuote() {
      return quote;
   }

   public void setQuote(boolean quote) {
      this.quote = quote;
   }

   public Client getClient() {
      return client;
   }

   public void setClient(Client client) {
      this.client = client;
   }

   public float getBase() {
      return base;
   }

   public void setBase(float base) {
      this.base = base;
   }

   public Note getNote() {
      return note;
   }

   public void setNote(Note note) {
      this.note = note;
   }

   public boolean isIssued() {
      return issued;
   }

   public void setIssued(boolean issued) {
      this.issued = issued;
   }

}
