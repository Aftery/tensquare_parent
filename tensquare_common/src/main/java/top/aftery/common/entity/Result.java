package top.aftery.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName Result
 * @Description Result
 * @Author Aftery
 * @Date 2020/1/16 19:27
 * @Version 1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
