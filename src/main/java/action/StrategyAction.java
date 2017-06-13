package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import service.strategy.StrategyBackTestingService;
import vo.strategy.AbnormalReturnResultVO;
import vo.strategy.StrategyBackTestInputVO;
import vo.strategy.StrategyBackTestResultVO;

import java.util.ArrayList;

/**
 * Created by duoduogao on 17/6/5.
 */
public class StrategyAction extends ActionSupport{

    private StrategyBackTestInputVO strategyBackTestInputVO;
    private String result;
private ArrayList<String > strings;

    public ArrayList<String> getStrings() {
        return strings;
    }

    public void setStrings(ArrayList<String> strings) {
        this.strings = strings;
    }

    private StrategyBackTestResultVO strategyBackTestResultVO;
    private AbnormalReturnResultVO abnormalReturnResultVO;

    @Autowired
    private StrategyBackTestingService strategyBackTestingService;

    public String test(){
        if (strings!=null){
//            System.out.println(strategyBackTestInputVO);
            for (String s:strings) {
                System.out.println(s);
            }
            result = "hhsuccess";
        }else {
            result = "wwfail";
        }
        return SUCCESS;
    }

    public String getStrategyBackTesting(){
        ArrayList<String> codes = strategyBackTestInputVO.getStockCodes();
        for (String s:codes) {
            System.out.println(s);
        }
        strategyBackTestResultVO = strategyBackTestingService.getStrategyBackTesting(strategyBackTestInputVO);
        result = JSONObject.fromObject(strategyBackTestResultVO).toString();
        return SUCCESS;
    }

    public String getAbnormalReturnGraphInfo(){
        abnormalReturnResultVO = strategyBackTestingService.getAbnormalReturnGraphInfo(strategyBackTestInputVO);
        result = JSONObject.fromObject(abnormalReturnResultVO).toString();
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

    public AbnormalReturnResultVO getAbnormalReturnResultVO() {
        return abnormalReturnResultVO;
    }

    public void setAbnormalReturnResultVO(AbnormalReturnResultVO abnormalReturnResultVO) {
        this.abnormalReturnResultVO = abnormalReturnResultVO;
    }
}

