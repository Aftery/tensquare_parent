package top.aftery.qa.controller;

import cn.hutool.core.util.StrUtil;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.aftery.common.entity.PageResult;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;
import top.aftery.qa.clien.LabelClient;
import top.aftery.qa.pojo.Problem;
import top.aftery.qa.service.ProblemService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Struct;
import java.util.Map;

/**
 * @ClassName ProblemController
 * @Description ProblemController
 * @Author Aftery
 * @Date 2020/1/20 14:43
 * @Version 1.0
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LabelClient labelClient;

    @GetMapping("/label/{labelid}")
    public Result findLabelById(@PathVariable String labelid){

        return labelClient.findById(labelid);
    }

    @GetMapping("/newlist/{labelid}/{page}/{size}")
    public Result newlist(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        Page<Problem> newlist = problemService.newlist(labelid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Problem>(newlist.getTotalElements(), newlist.getContent()));
    }

    @GetMapping("/hotlist/{labelid}/{page}/{size}")
    public Result hotlist(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
		Page<Problem> hotlist = problemService.hotlist(labelid, page, size);
		return new Result(true, StatusCode.OK, "查询成功", new PageResult<Problem>(hotlist.getTotalElements(), hotlist.getContent()));

    }

    @GetMapping("/waitlist/{labelid}/{page}/{size}")
    public Result waitlist(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
		Page<Problem> waitlist = problemService.waitlist(labelid, page, size);
		return new Result(true, StatusCode.OK, "查询成功", new PageResult<Problem>(waitlist.getTotalElements(), waitlist.getContent()));
    }


    /**
     * 查询全部数据
     *
     * @return
     */
    @GetMapping()
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", problemService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", problemService.findById(id));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @PostMapping(value = "/search")
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusCode.OK, "查询成功", problemService.findSearch(searchMap));
    }

    /**
     * 增加
     *
     * @param problem
     */
    @PostMapping()
    public Result add(@RequestBody Problem problem) {
        Object user_claims = request.getAttribute("user_claims");
        System.out.println("user_claims = " + user_claims);
        if(null==user_claims){
            return new Result(false, StatusCode.ACCESSERROR, "请先登录!");
        }
        problemService.add(problem);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param problem
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Problem problem, @PathVariable String id) {
        problem.setId(id);
        problemService.update(problem);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        problemService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
