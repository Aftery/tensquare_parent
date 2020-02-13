package top.aftery.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.aftery.common.entity.PageResult;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;
import top.aftery.base.pojo.Label;
import top.aftery.base.service.LabelService;

import java.util.List;

/**
 * @ClassName BaseController
 * @Description BaseController
 * @Author Aftery
 * @Date 2020/1/17 14:33
 * @Version 1.0
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    @GetMapping("/{labelId}")
    public Result findById(@PathVariable String labelId) {
        log.info("2222222222222222{}",8003);
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(labelId));
    }

    @PostMapping
    public Result save(@RequestBody  Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @PutMapping("/{labelId}")
    public Result update(@PathVariable String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @DeleteMapping("/{labelId}")
    public Result deleteById(@PathVariable String labelId) {
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }


    @PostMapping("/search")
    public  Result findSearch(@RequestBody Label label){
        List<Label> list =labelService.findSearch(label);
        return  new Result(true,StatusCode.OK,"查询成功",list);
    }

    @PostMapping("/search/{page}/{size}")
    public Result pageSearch(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
        Page<Label> list =labelService.pageSearch(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(list.getTotalElements(),list.getContent()));
    }


}





