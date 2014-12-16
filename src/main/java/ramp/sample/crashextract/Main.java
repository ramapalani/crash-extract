package ramp.sample.crashextract;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("spring-beans.xml");

			Driver driver = (Driver) context.getBean("driver");
			driver.start();
		} finally {
			if (context != null) {
				((ConfigurableApplicationContext) context).close();
			}
		}
	}

}
