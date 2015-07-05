package jaanero.facturas.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FacturasWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {MyBatisConfig.class, WebConfig.class  };	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" }; 
	}

}
