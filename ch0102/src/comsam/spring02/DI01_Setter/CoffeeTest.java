package comsam.spring02.DI01_Setter;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class CoffeeTest {
	public static void main(String[] args) {
        //실행시 Person.xml을 이용해 빈을 생성, 에러 생기면 최상위 경로로 옮길것
	    //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("person.xml"));
	
	   //아이디가 personService 빈을 가져온다.
	   //PersonService person =new PersonServiceImpl();
	   //PersonService person =(PersonService)factory.getBean("personService");
		
		
		
		//경로에 없다는 에러시 person.xml을 src 로 옮긴다. 
		ApplicationContext  context =new ClassPathXmlApplicationContext("person.xml");
	    OrderService order =(OrderService) context.getBean("orderService");
	    order.order();
	
	}
	//
	
	//version 3
// dfdfdfdfdf 
}
