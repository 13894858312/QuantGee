package vo;

/**
 * Created by wangxue on 2017/4/18.
 */
public class AandBVO {

    BackTestingResultVO backTestingResultVO;
    AbnormalReturnGraphVO abnormalReturnGraphVO;

    public AandBVO(BackTestingResultVO backTestingResultVO , AbnormalReturnGraphVO abnormalReturnGraphVO){
        this.abnormalReturnGraphVO = abnormalReturnGraphVO;
        this.backTestingResultVO = backTestingResultVO;
    }
}
