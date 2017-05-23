import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Repository;

import com.pularsight.repository.CustomerRepository;
import com.pularsight.repository.HibernateCustomerRepositoryImpl;
import com.pularsight.service.CustomerService;
import com.pularsight.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.pularsight"}) //This is for auto wiring 
//@ComponentScan(basePackages = {"com.pularsight"})
@PropertySource("app.properties")
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean("customerService")
	public CustomerService getCustomerService(){
		//This is constructor injection
		//CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRespository());
		
		//This is setter injection
		CustomerServiceImpl service = new CustomerServiceImpl();
		//service.setCustomerRepository(getCustomerRespository()); // comenting because we are using auto wiring
		return service;
		
	}
	//This is not requested if we are using auto wiring with  @Repository
	@Bean("customerRepository")
	public CustomerRepository getCustomerRespository(){
		return new HibernateCustomerRepositoryImpl();
	}
	
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}*/
}
