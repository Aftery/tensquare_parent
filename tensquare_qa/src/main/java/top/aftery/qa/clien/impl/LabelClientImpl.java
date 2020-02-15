package top.aftery.qa.clien.impl;

import org.springframework.stereotype.Service;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;
import top.aftery.qa.clien.LabelClient;

/**
 * @ClassName LabelClientImpl
 * @Description LabelClientImpl
 * @Author Aftery
 * @Date 2020/2/14 18:47
 * @Version 1.0
 */
@Service
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String labelId) {

        return new Result(false, StatusCode.ERROR, "对不起,你请求的服务当前不可用!");
    }
}
