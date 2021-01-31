
package com.core.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.core.spring.config.Config;
import com.core.spring.service.MyService;

@Component
public class App {

	// private CompanyDao dao;

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MyService service =  (MyService) context.getBean("myServiceImpl");

		service.saveCompanyAndDept();
		
		//service.saveCompanyFiveObj();

		 

		context.close();
	}
}
