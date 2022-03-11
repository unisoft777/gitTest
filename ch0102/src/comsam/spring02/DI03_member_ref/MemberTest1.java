package comsam.spring02.DI03_member_ref;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;


public class MemberTest1 {
	public static void main(String[] args) {
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("member.xml"));
//		MemberService service=(MemberService)factory.getBean("memberService");
//		service.listMembers();
		
		ApplicationContext  context =new ClassPathXmlApplicationContext("member.xml");
		MemberService service =(MemberService) context.getBean("memberService");
     	service.listMembers();
	}
}
