package top.aftery.qa.clien;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.aftery.common.entity.Result;
import top.aftery.qa.clien.impl.LabelClientImpl;

/**
 * @ClassName LabelClient
 * @Description LabelClient
 * @Author Aftery
 * @Date 2020/2/12 15:34
 * @Version 1.0
 */
@Component
@FeignClient(value = "tensquare-base", fallback = LabelClientImpl.class)
public interface LabelClient {

    @GetMapping("/label/{labelId}")
    public Result findById(@PathVariable(value = "labelId") String labelId);
}
