package jaanero.facturas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "CLIENT_KEY")
   private Long id;
   @Column(name = "CLIENT_NAME")
   private String name;
   @Column(name = "CLIENT_CIF")
   private String cif;
   @Column(name = "CLIENT_SUBNAME")
   private String subname;
   @Column(name = "CLIENT_ADDRESS")
   private String address;
   @Column(name = "CLIENT_ZIPCODE")
   private String zipcode;
   @Column(name = "CLIENT_CITY")
   private String city;
   @Column(name = "CLIENT_PROVINCE")
   private String province;

   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "CLIENT_KEY")
   private List<Invoice> invoices;

   public String getCif() {
      return cif;
   }

   public void setCif(String cif) {
      this.cif = cif;
   }

   public String getSubname() {
      return subname;
   }

   public void setSubname(String subname) {
      this.subname = subname;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getProvince() {
      return province;
   }

   public void setProvince(String province) {
      this.province = province;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public static class ClientBuilder {

      private String name;
      private String cif;
      private String subname;
      private String address;
      private String zipcode;
      private String city;
      private String province;

      public ClientBuilder(String name) {
         super();
         this.name = name;
      }

      public Client build() {
         Client client = new Client();
         client.setAddress(address);
         client.setCif(cif);
         client.setCity(city);
         client.setName(name);
         client.setProvince(province);
         client.setSubname(subname);
         client.setZipcode(zipcode);
         return client;
      }

      public ClientBuilder setCIF(String cif) {
         this.cif = cif;
         return this;
      }

      public ClientBuilder setSubname(String subname) {
         this.subname = subname;
         return this;
      }

      public ClientBuilder setAddress(String address) {
         this.address = address;
         return this;
      }

      public ClientBuilder setZipcode(String zipcode) {
         this.zipcode = zipcode;
         return this;
      }

      public ClientBuilder setCity(String city) {
         this.city = city;
         return this;
      }

      public ClientBuilder setProvince(String province) {
         this.province = province;
         return this;
      }

   }

   public List<Invoice> getInvoices() {
      return invoices;
   }

   public void setInvoices(List<Invoice> invoices) {
      this.invoices = invoices;
   }

   public static ClientBuilder aClient(String clientName) {
      return new ClientBuilder(clientName);
   }

}
