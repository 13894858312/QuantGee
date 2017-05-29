package logic.calculation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mark.W on 2017/5/29.
 */
public class main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml");
        KdjCalculation kdjCalculation = (KdjCalculation) context.getBean("kdjCalculation");
        kdjCalculation.start();

//        BollCalculation bollCalculation = (BollCalculation)context.getBean("bollCalculation");
//        bollCalculation.start();
//
//        RsiCalculation rsiCalculation = (RsiCalculation)context.getBean("rsiCalculation");
//        rsiCalculation.start();
//
//        MacdCalculation macdCalculation = (MacdCalculation) context.getBean("macdCalculation");
//        macdCalculation.start();

//        new BpPredict().start();
    }
}
