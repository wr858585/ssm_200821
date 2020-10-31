package com.atguigu.test;

import com.atguigu.mapper.BookMapper;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.BookExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 30
 */
public class BookMapperTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void countByExample() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            //大的查询条件
            BookExample bookExample = new BookExample();
            //创建一个条件对象
            //Criteria是BookExample的内部类
            BookExample.Criteria criteria = bookExample.createCriteria();
            //价格大于50的图书数量是多少
            criteria.andPriceGreaterThan(new BigDecimal("50"));
            criteria.andSalesGreaterThan(100);
            /**
             * countByExample()：用于执行count()数量的统计，ByExample是根据条件来
             */
            int count = bookMapper.countByExample(bookExample);
            System.out.println(count);
        }
    }

    @Test
    public void deleteByExample() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapperImpl = sqlSession.getMapper(BookMapper.class);
            //大的查询条件
            BookExample bookExample = new BookExample();
            //创建一个条件对象
            BookExample.Criteria criteria = bookExample.createCriteria();
            criteria.andAuthorEqualTo("国哥");
            bookExample.or().andNameLike("%数据%");
//            criteria.andNameLike("%数据%");
//            bookExample.createCriteria().andAuthorEqualTo("国哥");
//            bookExample.or().andNameLike("数据");
            /**
             * deleteByExample()根据条件做删除操作
             * 删除的作者是国哥 | 书名中包含“数据”的图书
             */
            int i = bookMapperImpl.deleteByExample(bookExample);
            sqlSession.commit();
        }
    }

    @Test
    public void deleteByPrimaryKey() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapperImpl = sqlSession.getMapper(BookMapper.class);
            bookMapperImpl.deleteByPrimaryKey(1);
            sqlSession.commit();
        }
    }

    @Test
    public void insert() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapperImpl = sqlSession.getMapper(BookMapper.class);
            bookMapperImpl.insert(new Book(null,"国哥好帅",null,null,1234,1234));
            sqlSession.commit();
        }
    }

    @Test
    public void insertSelective() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapperImpl = sqlSession.getMapper(BookMapper.class);
            bookMapperImpl.insertSelective(new Book(null,"国哥好帅",null,null,1234,1234));
            sqlSession.commit();
        }
    }

    @Test
    public void selectByExample() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapperImpl = sqlSession.getMapper(BookMapper.class);
            //创建BookExample对象
            BookExample bookExample = new BookExample();
            //optional：排序
            bookExample.setOrderByClause("price desc");
            //创建条件
            BookExample.Criteria criteria = bookExample.createCriteria();
            /**
             * 条件：书名是怎样拐跑别人的媳妇 或 销量大于100
             */
            criteria.andNameEqualTo("怎样拐跑别人的媳妇");
            bookExample.or().andSalesGreaterThan(100);
            /**
             * selectByExample()：根据给定的条件查询图书信息
             */
            bookMapperImpl.selectByExample(bookExample).forEach(System.out::println);
        }
    }

    @Test
    public void selectByPrimaryKey() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapperImpl = sqlSession.getMapper(BookMapper.class);
            System.out.println(bookMapperImpl.selectByPrimaryKey(10));
        }
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
        //用的很少，容易出问题
    }

    @Test
    public void updateByPrimaryKeySelective() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapperImpl = sqlSession.getMapper(BookMapper.class);
            bookMapperImpl.updateByPrimaryKeySelective(new Book(10,null,"该作者是我哦",null,null,null));
            sqlSession.commit();
            //有了selective的方法，null会不修改，因为sql语句直接不写null的行，所以这里只有一个占位符-->author = ?
        }
    }

    @Test
    public void updateByPrimaryKey() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            BookMapper bookMapperImpl = sqlSession.getMapper(BookMapper.class);
            bookMapperImpl.updateByPrimaryKey(new Book(11,null,"作者还是我哦",null,null,null));
            sqlSession.commit();
            //没有selective的方法，null也会写入sql，所以这里占位符都有?,?,?,?,?。由于只有author有值，所以其他有值的都全部改为空
        }
    }
}