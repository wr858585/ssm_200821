package com.atguigu.test;

import com.atguigu.mapper.ClazzMapper;
import com.atguigu.mapper.StudentMapper;
import com.atguigu.pojo.Clazz;
import com.atguigu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 29
 */
public class ClazzMapperTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void queryClazzByIdForSimple() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ClazzMapper clazzMapperImpl = sqlSession.getMapper(ClazzMapper.class);
            clazzMapperImpl.queryClazzByIdForSimple(1);
        }
    }

    @Test
    public void testQueryClazzByIdForTwoSteps(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ClazzMapper clazzMapperImpl = sqlSession.getMapper(ClazzMapper.class);
            Clazz clazz = clazzMapperImpl.queryClazzByIdForTwoSteps(1);
            System.out.println(clazz.getName());
            Thread.sleep(2000);
            System.out.println(clazz.getStudents());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryStudentsByClazzIdAndLikeName() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ClazzMapper clazzMapperImpl = sqlSession.getMapper(ClazzMapper.class);
//            StudentMapper studentMapperImpl = sqlSession.getMapper(StudentMapper.class);
//            List<Student> ee = studentMapperImpl.queryStudentByClazzIdAndLikeName(1, "EE");
//            System.out.println(ee);

            Clazz clazz = clazzMapperImpl.queryClazzByIdAndLikeNameForTwoSteps(1, "EE");
            System.out.println(clazz.getName());
//            Thread.sleep(2000);
            System.out.println(clazz.getStudents());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }
    }
}