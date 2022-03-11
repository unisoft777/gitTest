package comsam.spring02.DI02_Construct;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import comsam.spring02.DI02_Construct.OrderService;

public class CoffeeTest2 {

	public static void main(String[] args) {
//		BeanFactory factory =new XmlBeanFactory(new FileSystemResource("person.xml"));
//		PersonService person1=(PersonService)factory.getBean("personService1");
//		person1.sayHello();
//		System.out.println();
//		
//		PersonService person2= (PersonService)factory.getBean("personService2");
//		person2.sayHello();
		
		ApplicationContext  context =new ClassPathXmlApplicationContext("person.xml");
	    OrderService person1 =(OrderService) context.getBean("personService1");
	    person1.order();
	    
		System.out.println();
		OrderService person2 =(OrderService) context.getBean("personService2");
	    person2.order();
		
	}

}
