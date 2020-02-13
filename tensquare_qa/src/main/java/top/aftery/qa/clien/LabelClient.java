package top.aftery.qa.clien;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.aftery.common.entity.Result;

/**
 * @ClassName LabelClient
 * @Description LabelClient
 * @Author Aftery
 * @Date 2020/2/12 15:34
 * @Version 1.0
 */
@Component
@FeignClient("tensquare-base")
public interface LabelClient {

    @GetMapping("/label/{labelId}")
    public Result findById(@PathVariable(value = "labelId") String labelId);
}
