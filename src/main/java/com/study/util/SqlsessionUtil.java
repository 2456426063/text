package com.study.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlsessionUtil

{
    private  static SqlSessionFactory factory;
    static{
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder  = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }

    private static ThreadLocal<SqlSession> thread = new ThreadLocal<>();

    public static SqlSession getSqlsession(){
        SqlSession sqlSession = thread.get();
        if (sqlSession==null){
            sqlSession = factory.openSession();
            thread.set(sqlSession);
        }
        /*SqlSession sqlSession = factory.openSession();*/
        return sqlSession;
    }

    public static void close(SqlSession session){
        if (session!=null) {
            session.close();
            thread.remove();
        }
    }
}
