package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {SpringMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

}
