package com.study.util;

public class ServiceFactory {
    public static Object getService(Object service){
        return new Transaction(service).getProxy();
    }
}
