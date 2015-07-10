package jaanero.facturas.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jaanero.facturas.mapper.ClientMapper;

@Configuration
public class MyBatisConfig {
   private static final String MAPPERS_PACKAGE = "jaanero.facturas.mapper";

   @Bean
   public MapperScannerConfigurer mapperScannerConfigurer() {
      MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
      mapperScannerConfigurer.setBasePackage(MAPPERS_PACKAGE);
      return mapperScannerConfigurer;
   }

   @Bean
   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
      SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
      sf.setDataSource(dataSource);
      return sf.getObject();
   }

   @Bean
   public ClientMapper clientMapper(DataSource dataSource) throws Exception {
      MapperFactoryBean<ClientMapper> mapperFactoryBean = new MapperFactoryBean<ClientMapper>();
      mapperFactoryBean.setMapperInterface(ClientMapper.class);
      mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory(dataSource));
      mapperFactoryBean.afterPropertiesSet();
      return mapperFactoryBean.getObject();
   }
}
