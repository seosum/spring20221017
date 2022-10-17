package lecture.p13core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context 
		= new AnnotationConfigApplicationContext(Config.class);
	
	Servlet s = context.getBean(Servlet.class);
	Dao d = context.getBean(Dao.class);
	
	System.out.println(s);
	System.out.println(d);
	
	System.out.println("프로그램 실행 계속");
	}
}
