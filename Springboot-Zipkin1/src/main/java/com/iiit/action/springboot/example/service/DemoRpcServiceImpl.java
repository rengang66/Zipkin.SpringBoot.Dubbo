package com.iiit.action.springboot.example.service;


import com.iiit.action.dubbo.demo.api.DemoRpcService;
import org.springframework.stereotype.Service;

/**
 * @author rengang
 * @version 1.0
 * @title
 * @time 2018年10月24日
 * @since 1.0
 */
@Service("demoRpcService")
public class DemoRpcServiceImpl implements DemoRpcService {

    public String getUserName(String uid) {
        try {
            System.out.println("接受RPC调用入参：" + uid + ";开始处理！");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("返回结果！");
        return "任同学";
    }
}
