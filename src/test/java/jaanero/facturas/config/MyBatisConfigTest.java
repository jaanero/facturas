package jaanero.facturas.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import jaanero.facturas.mapper.ClientMapper;

@Configuration
public class MyBatisConfigTest {
	
	private static final String MAPPERS_PACKAGE = "jaanero.facturas.mapper";
	
	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(MAPPERS_PACKAGE);
        return mapperScannerConfigurer;
    }
	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder()
				.addScript("classpath:schema.sql")
				.addScript("classpath:testData.sql")
				.build();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setDataSource(dataSource());
		return sf.getObject();
	}
	
	@Bean
	public ClientMapper clientMapper() throws Exception {
		MapperFactoryBean<ClientMapper> mapperFactoryBean = new MapperFactoryBean<ClientMapper>();
		mapperFactoryBean.setMapperInterface(ClientMapper.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
		mapperFactoryBean.afterPropertiesSet();
		return mapperFactoryBean.getObject();
	}
}
