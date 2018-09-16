package in.hocg.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import in.hocg.base.support.scaffold.BaseController;
import in.hocg.base.util.http.GetPageCondition;
import in.hocg.base.util.http.PostPageCondition;
import in.hocg.beta.Test2;
import in.hocg.web.pojo.domain.Example;
import in.hocg.web.service.ExampleService;
import in.hocg.web.support.base.aspect.log.ILog;
import in.hocg.web.support.base.json.annotation.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * @author hocgin
 * @date 2018/6/12
 * email: hocgin@gmail.com
 */
@Slf4j
@Controller
@RequestMapping("/example")
public class ExampleController extends BaseController {
    
    private final ExampleService exampleService;
    
    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }
    
    @RequestMapping("ignore.json")
    @ResponseBody
    public ResponseEntity ignore() {
        return ResponseEntity.ok("It`s Working");
    }
    
    
    @PostMapping("/checkSMS")
    @ResponseBody
    public ResponseEntity checkSMS() {
        String text = String.format("检查短信验证码: %s", LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        return ResponseEntity.ok(text);
    }
    
    @PostMapping("/sendSMS")
    @ResponseBody
    public ResponseEntity sendSMS(HttpServletRequest request) throws Exception {
        String text = String.format("发送一条短信验证码: %s", LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        return ResponseEntity.ok(text);
    }
    
    
    @GetMapping("/imageCode")
    @ResponseBody
    public void getImageCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.debug("正在渲染一张图片验证码");
    }
    
    @PostMapping("/checkImageCode")
    @ResponseBody
    public ResponseEntity checkImageCode() {
        String text = String.format("检查图片验证码: %s", LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        return ResponseEntity.ok(text);
    }
    
    @GetMapping("/page")
    @ResponseBody
    public ResponseEntity page(GetPageCondition condition) throws JsonProcessingException {
        Optional<Set<String>> is = condition.getConditionValue("is");
        log.debug("Is : {}", is.orElse(Collections.EMPTY_SET));
        
        
        Page<Example> page = exampleService.page(condition);
        return ResponseEntity.ok(condition);
    }
    
    @GetMapping("/i/{id}")
    @ResponseBody
    public ResponseEntity find(@PathVariable("id") String id) {
        log.debug(id);
        return ResponseEntity.ok(id);
    }
    
    @RequestMapping(value = "/test3", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity test3(@Validated @RequestBody PostPageCondition<Test2> test,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.ok(bindingResult.getAllErrors());
        }
        
        return ResponseEntity.ok(test);
    }
    
    @RequestMapping(value = "/test4", method = {RequestMethod.POST})
    @ResponseBody
    @JSON(type = Test2.class, exclude = "id")
    @JSON(type = Test2.Test1.class, exclude = "name")
    @ILog
    public ResponseEntity<Test2> test4() {
        Test2 body = new Test2();
        Test2.Test1 test1 = new Test2.Test1();
        test1.setName("test1");
        body.setTest1(test1);
        body.setId("123");
        body.setName("1234");
        return ResponseEntity.ok(body);
    }
    
}
