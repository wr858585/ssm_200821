package com.atguigu.test;

import com.atguigu.mapper.KeyMapper;
import com.atguigu.pojo.Key;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 28
 */
public class KeyMapperTest {

    SqlSessionFactory sqlSessionFactory;

    //运用@Before注解给每个测试方法都提供一个前置的功能对象
    @Before
    public void setUp() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void testQueryKeyById() {
        //将openSession()语句写入try的括号中，之后可以不用关流（新特性）
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            KeyMapper mapperImpl = sqlSession.getMapper(KeyMapper.class);
            Key key = mapperImpl.queryKeyById(1);
            System.out.println(key);
        }
    }

    @Test
    public void testQueryKeyByIdForTwoSteps(){
        try(SqlSession sqlsession = sqlSessionFactory.openSession()){
            KeyMapper mapperImpl = sqlsession.getMapper(KeyMapper.class);
            Key key = mapperImpl.queryKeyByIdForTwoSteps(1);
            System.out.println(key.getId());
            System.out.println(key.getName());
            System.out.println(key.getLock());
         }
    }
}