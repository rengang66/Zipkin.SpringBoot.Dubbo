package com.iiit.action.dubbo.demo.api;

public interface DemoRpcService {

    /**
     * 测试方法
     *
     * @return
     */
    String getUserName(String uid);
}
