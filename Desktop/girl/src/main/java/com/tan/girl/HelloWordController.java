package com.tan.girl;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 谭永超 [www.tanyongchao.tk:8090/SumDome/index]
 * @Date 2018/8/19 16:42
 * @Description 获取配置文档application.yml的配置信息
*/
@RestController
@RequestMapping(value = "/hello")
//@PropertySource("classpath:application.yml")
public class HelloWordController {
@Autowired
private GirlProperties girlProperties;
//    @Value("${content}")
//    String name;
    @RequestMapping(value = "/{name}")
    public String hello(@RequestParam(value = "id",required = false,defaultValue = "1") int id,
                        @PathVariable(value = "name",required = false)String name,
                        @ModelAttribute(value = "ss")String s){
        System.out.println(name);
        System.out.println(girlProperties.getContent());
        System.out.println(girlProperties.getAge());
        return "Hello Word!";
    }
}
