package tushare2java;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/15.
 */
public class News {

    public ArrayList<News> getTop_n_News(int n){
        ArrayList<News> newsArrayList = new ArrayList<News>();
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        pythonInterpreter.execfile("getNews.py");
        PyFunction pyFunction = (PyFunction)pythonInterpreter.get("get_top_n_news",PyFunction.class);
        pyFunction.__call__(new PyInteger(n));

        return newsArrayList;
    }
}
