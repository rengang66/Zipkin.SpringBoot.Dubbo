package com.iiit.action.springboot.example.controller;

import com.iiit.action.dubbo.demo.api.DemoRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ZipkinController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DemoRpcService demoRpcService;

    @GetMapping("/service0")
    public String service() throws Exception {
        Thread.sleep(100);
        Map map = new HashMap<>();
        map.put("name", "我是rest请求！");
        ResponseEntity<String> response = restTemplate.postForEntity("http://127.0.0.1:8081/service1", map, String.class);
        return response.getBody();
    }


    @GetMapping("/test")
    public String testDubbo() throws Exception {
    	
    	String returnString  = null;
    	
        System.out.println("接受http请求：");
        returnString = "接受http请求：" ;
        returnString = returnString + "\r\n <br/>" ;
        Thread.sleep(1000);
        System.out.println("发起RPC调用");
        returnString = returnString + "发起RPC调用" ;
        returnString = returnString + "\r\n <br/>" ;
        String name = demoRpcService.getUserName("dubbo1");
        System.out.println("处理RPC调用返回结果：" + name);
        returnString = returnString + "处理RPC调用返回结果：" + name  ;
        returnString = returnString + "\r\n <br/>" ;
        Thread.sleep(1500);

        System.out.println("发起restTemplate:");
        returnString = returnString + "发起restTemplate:" ;
        returnString = returnString + "\r\n <br/>" ;
        Map map = new HashMap<>();
        map.put("name", "我是rest请求！");
        String response = restTemplate.getForObject("http://127.0.0.1:8081/service1", String.class, map);
        System.out.println("接受testTemplate:" + response);
        
        returnString = returnString + "接受testTemplate:" + response;
        
        return returnString;
    }
}
