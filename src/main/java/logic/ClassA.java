package logic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Mark.W on 2017/5/19.
 */
@Service
@Scope("prototype")
public class ClassA implements InterfaceA{

    public static int id = 0;

    public ClassA() {
        id ++;
    }

    @Override
    public void getName() {
        System.out.println("I'm ClassA " + id);
    }


}
