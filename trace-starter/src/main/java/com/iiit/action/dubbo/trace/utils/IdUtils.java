package com.iiit.action.dubbo.trace.utils;

import java.util.Random;

/**
 * @author rengang
 * @version 1.0
 * @title
 * @time 2018年10月25日
 * @since 1.0
 */
public class IdUtils {
    public static Long getId() {
        return NetworkUtils.getIp() + System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println("id：" + new Random().nextLong());
    }
}
