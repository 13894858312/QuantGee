package vo.strategy;

/**
 * Created by wangxue on 2017/4/18.
 */
public class AbnormalReturnAndBackTestVO {

    private StrategyBackTestResultVO strategyBackTestResultVO;
    private AbnormalReturnGraphVO abnormalReturnGraphVO;

    public AbnormalReturnAndBackTestVO(StrategyBackTestResultVO strategyBackTestResultVO, AbnormalReturnGraphVO abnormalReturnGraphVO){
        this.abnormalReturnGraphVO = abnormalReturnGraphVO;
        this.strategyBackTestResultVO = strategyBackTestResultVO;
    }

    public StrategyBackTestResultVO getStrategyBackTestResultVO() {
        return strategyBackTestResultVO;
    }

    public void setStrategyBackTestResultVO(StrategyBackTestResultVO strategyBackTestResultVO) {
        this.strategyBackTestResultVO = strategyBackTestResultVO;
    }

    public AbnormalReturnGraphVO getAbnormalReturnGraphVO() {
        return abnormalReturnGraphVO;
    }

    public void setAbnormalReturnGraphVO(AbnormalReturnGraphVO abnormalReturnGraphVO) {
        this.abnormalReturnGraphVO = abnormalReturnGraphVO;
    }
}
