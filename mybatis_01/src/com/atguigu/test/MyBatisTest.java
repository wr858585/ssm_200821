package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author oono
 * @date 2020 10 27
 */
public class MyBatisTest {

    //把sqlSessionFactory对象申明为全局对象，才能在每个方法中使用
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void setup() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void testQueryUserById() throws IOException {

        //1.读取mybatis-config.xml的配置文件信息
        //导入的是ibatis的Resources包，调用Resources.getResourceAsStream()方法
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

/*
        //2.通过SqlSessionFactoryBuilder创建SqlSFB对象
        SqlSessionFactoryBuilder sqlSFB = new SqlSessionFactoryBuilder();
        //2.1通过build()方法读取is的内容，创建出session对象
        SqlSessionFactory sqlSF = sqlSFB.build(is);

        //3.通过sqlSF开启会话，用openSession()方法创建session对象
        SqlSession session = sqlSF.openSession();
*/

        //合成一步
        SqlSession session = new SqlSessionFactoryBuilder().build(is).openSession();

        //sqlSF就相当于Connection对象，用完之后要关闭放回连接池类似释放资源 --> 用finally关闭
        try{
            //4.通过session获取UserMapper接口的实现类
            UserMapper mapper = session.getMapper(UserMapper.class);
            //5.执行查询
            System.out.println(mapper.queryUserById(1));
        } finally{
            session.close();
        }
    }

    @Test
    public void testInsertUser() throws IOException {

        //1.读取mybatis-config.xml中的配置信息
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.用FactoryBuilder创建session对象
        SqlSession session = new SqlSessionFactoryBuilder().build(is).openSession();

        //3.创建UserMapperImpl实现类，调用CRUD方法
        try{
            UserMapper userMapperImpl = session.getMapper(UserMapper.class);
            userMapperImpl.insertUser(new User(null, "庄熙", 1));
            //注意：对于增加删除修改的操作，一定要commit才会生效，否则rollback
            session.commit();
        } finally{
            session.close();
        }
    }

    @Test
    public void testUpdateUser() throws IOException {

        //1.读取mybatis-config.xml中的配置信息
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.运用sqlSessionFactoryBuilder创建session对象
        SqlSession session = new SqlSessionFactoryBuilder().build(is).openSession();

        //3.创建Mapper实现类，再调用CRUD方法
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateUser(new User(3,"庄熙大傻瓜",1));
            session.commit();
        } finally{
            session.close();
        }
    }

    @Test
    public void testDeleteUser() throws IOException {

        //1.获取mybatis-config.xml中的配置信息
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.用sqlSessionFactory创建session对象
        SqlSession session = new SqlSessionFactoryBuilder().build(is).openSession();

        //3.创建mapper的实现类，调用CRUD方法
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.deleteUser(2);
            session.commit();
        } finally{
            session.close();
        }
    }

    @Test
    public void testQueryUsers(){

        //1.直接用setup()方法中已经创建好的对象sqlSessionFactory来openSession

        //2.创建UserMapper接口的实现类，调用CRUD
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapperImpl = sqlSession.getMapper(UserMapper.class);
            mapperImpl.queryUsers().forEach(System.out::println);
        }
    }

    @Test
    public void testQueryUserBySexOrName() throws IOException {

        //1.直接使用setup()方法生成的SqlSessionFactory对象
        //2.try(...){...}这样不用使用finally对(...)中的语句进行关流了，会自动关流
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserMapper mapperImpl = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapperImpl.queryUsersBySexOrName(1, "庄熙");
            System.out.println(users);
        }
    }

    @Test
    public void testQueryUsersLikeName(){

        //1.直接使用setup()方法生成的SqlSessionFactory对象
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            //2.生成mapperImpl，调用方法
            UserMapper mapperImpl = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapperImpl.queryUsersLikeName("熙"));
        }
    }


}
