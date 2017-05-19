package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mark.W on 2017/5/19.
 */
@Service
public class ClassB {
    @Autowired
    private InterfaceA interfaceA;

    public void run() {
        interfaceA.getName();
    }

}
