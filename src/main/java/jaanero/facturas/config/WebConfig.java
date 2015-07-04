package jaanero.facturas.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import jaanero.facturas.mapper.ClientMapper;
import jaanero.facturas.service.ClientService;
import jaanero.facturas.service.ClientServiceImpl;



@Configuration
@EnableWebMvc
@ComponentScan("jaanero.facturas")
public class WebConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
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
	
	@Bean
	public ClientService clientService() throws Exception{
		ClientServiceImpl cs = new ClientServiceImpl();
		cs.setClientMapper(clientMapper());
		return cs;
	}

	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
