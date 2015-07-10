package jaanero.facturas.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = "jaanero.facturas.persistence")
public class JpaConfig {

   @Autowired
   private EntityManagerFactory entityManagerFactory;

   @Bean
   public JpaVendorAdapter jpaVendorAdapter() {
      HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
      adapter.setDatabase(Database.H2);
      adapter.setShowSql(true);
      adapter.setGenerateDdl(false);
      adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
      return adapter;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
         JpaVendorAdapter jpaVendorAdapter) {
      LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
      emfb.setDataSource(dataSource);
      emfb.setJpaVendorAdapter(jpaVendorAdapter);
      emfb.setPackagesToScan("jaanero.facturas.model");
      return emfb;
   }

   @Bean
   public JpaTransactionManager transactionManager() throws Exception {
      final JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory);

      return transactionManager;
   }

   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      final PersistenceExceptionTranslationPostProcessor exceptionTranslation = new PersistenceExceptionTranslationPostProcessor();

      return exceptionTranslation;
   }
}
