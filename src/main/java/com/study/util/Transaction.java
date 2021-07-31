package com.study.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Transaction implements InvocationHandler {



    Object target;
    public Transaction() {
    }

    public Transaction(Object target) {
        this.target = target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object org=null;
        SqlSession sqlSession =null;
        try{
            sqlSession = SqlsessionUtil.getSqlsession();
            org = method.invoke(target,args);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            SqlsessionUtil.close(sqlSession);
        }


        return org;

    }
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
