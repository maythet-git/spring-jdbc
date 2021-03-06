
package com.core.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.core.spring.config.Config;
import com.core.spring.dao.CompanyDao;
import com.core.spring.dao.impl.CompanyDaoImpl;
import com.core.spring.entity.Company;
import com.core.spring.service.CompanyService;

@Component
public class App {

	// private CompanyDao dao;

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		CompanyService service = (CompanyService) context.getBean("companyServiceImpl");

		//service.saveCompanyOneObj();
		
		//service.saveCompanyFiveObj();
		
		

		  
		/*
		 * company.setName(company.getName() + "XXYY");
		 * 
		 * service.update(company);
		 */
		  
		  //service.deleteById(1);
		  
		  //service.saveCompanyFiveObj();
			//service.deleteAll();
		  
		/*
		 * Company company = service.findById(1); System.out.println(company);
		 */
		//List<Company> company = service.findByAll();
		//Integer count = service.getCount();
		//System.out.println(count);
		 

		context.close();
	}
}
