import logic.ClassA;
import logic.ClassB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mark.W on 2017/5/19.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ClassA classA1 = (ClassA)context.getBean("classA");
//        classA1.getName();
//        ClassA classA2 = (ClassA)context.getBean("classA");
//        classA2.getName();

        ClassB classB = (ClassB)context.getBean("classB");
        classB.run();
    }
}
