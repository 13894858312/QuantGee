package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import service.strategy.StrategyBackTestingService;
import vo.strategy.StrategyBackTestInputVO;
import vo.strategy.StrategyBackTestResultVO;

/**
 * Created by duoduogao on 17/6/5.
 */
public class StrategyAction extends ActionSupport{

    private StrategyBackTestInputVO strategyBackTestInputVO;
    private String result;

    private StrategyBackTestResultVO strategyBackTestResultVO;

    @Autowired
    private StrategyBackTestingService strategyBackTestingService;

    public String test(){
        if (strategyBackTestInputVO!=null){
            System.out.println(strategyBackTestInputVO);
            result = "hhsuccess";
        }else {
            result = "wwfail";
        }
        return SUCCESS;
    }

    public String getStrategyBackTesting(){
        strategyBackTestResultVO = strategyBackTestingService.getStrategyBackTesting(strategyBackTestInputVO);
        result = JSONObject.fromObject(strategyBackTestResultVO).toString();
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

    public StrategyBackTestResultVO getStrategyBackTestResultVO() {
        return strategyBackTestResultVO;
    }

    public void setStrategyBackTestResultVO(StrategyBackTestResultVO strategyBackTestResultVO) {
        this.strategyBackTestResultVO = strategyBackTestResultVO;
    }
}

