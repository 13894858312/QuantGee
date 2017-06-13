package action;

import com.opensymphony.xwork2.ActionSupport;
import vo.strategy.StrategyBackTestInputVO;

/**
 * Created by duoduogao on 17/6/5.
 */
public class StrategyAction extends ActionSupport{

    private StrategyBackTestInputVO strategyBackTestInputVO;
    private String result;

    public String test(){
        if (strategyBackTestInputVO!=null){
            System.out.println(strategyBackTestInputVO);
            result = "hhsuccess";
        }else {
            result = "wwfail";
        }
        return SUCCESS;
    }

    public StrategyBackTestInputVO getStrategyBackTestInputVO() {
        return strategyBackTestInputVO;
    }

    public void setStrategyBackTestInputVO(StrategyBackTestInputVO strategyBackTestInputVO) {
        this.strategyBackTestInputVO = strategyBackTestInputVO;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

