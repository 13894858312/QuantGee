import org.junit.Test;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;
import po.NewsPO;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/15.
 */
public class PythonTest {

    @Test
    public void getTop_n_News(){
        ArrayList<NewsPO> newsPOS = new ArrayList<NewsPO>();
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        pythonInterpreter.execfile("src//main/java/tushare2java/getNews.py");
        PyFunction pyFunction = (PyFunction)pythonInterpreter.get("get_top_n_news",PyFunction.class);
        pyFunction.__call__(new PyInteger(8));

        return ;
    }

}
