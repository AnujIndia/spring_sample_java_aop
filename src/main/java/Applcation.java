import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pularsight.service.CustomerService;
import com.pularsight.service.CustomerServiceImpl;


public class Applcation {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerService service = appContext.getBean("customerService", CustomerService.class);
		System.out.println("Service Object 1 - :" +  service);
		
		/*CustomerService service2 = appContext.getBean("customerService", CustomerService.class);
		System.out.println("Service Object 1 - :" +  service2);
		*/
		
		System.out.print(service.findAll().get(0).getFirstName() + service.findAll().get(0).getLastName());

		
	
		

	}

}
