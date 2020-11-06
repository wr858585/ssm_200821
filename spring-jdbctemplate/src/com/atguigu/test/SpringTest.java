package com.atguigu.test;

import com.atguigu.pojo.Employee;
import com.atguigu.EmployeeDao;
import com.atguigu.tx.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author oono
 * @date 2020 11 05
 */

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

//    @Autowired
//    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    TransactionService transactionService;

    @Test
    public void test2(){

        String sql = "update employee set salary = ? where id = ?";
        //不用写任何的dao层方法，直接就可以使用update,query等spring写好的方法！

        System.out.println(jdbcTemplate.update(sql, 6000, 1));//1
    }

    @Test
    public void test3(){

        String sql = "insert into employee(name,salary) values(?,?)";

        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"aaaa",new BigDecimal("1000")});
        batchArgs.add(new Object[]{"bbbb",new BigDecimal("2000")});
        batchArgs.add(new Object[]{"cccc",new BigDecimal("3000")});

        System.out.println(jdbcTemplate.batchUpdate(sql,batchArgs));//address
    }

    @Test
    public void test4(){

        String sql = "select id, name, salary from employee where id = ?";
        /**
         * queryForObject()当查询回来的结果只有一行时，使用queryForObject()
         * 第一个参数：sql语句
         * 第二个参数：RowMapper接口实现类，这个接口的实现类需要将查询回来的每一行记录转换为javabean对象
         * 第三个参数：sql中的占位符参数
         */
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 5);
        System.out.println(employee);

    }

    @Test
    public void test5(){

        String sql = "select id, name, salary from employee where salary > ?";

        /**
         * JdbcTemplate类 VS DBUtils工具类中的QueryRunner类 --> 很相似！
         * JdbcTemplate类：
         * update()用来执行insert,update,delete等写入操作
         * queryForObject()用来查询一行数据
         * query()用来查询多行数据
         * QueryRunner类：
         * update()用来一摸一样
         * query()用来执行查询操作：
         *      ResultHandler接口实现决定查询回来的结果
         *          BeanHandler()实现类：查询一个对象
         *          BeanListHandler()实现类：查询多个对象
         *          ScalarHandler()实现类：查询某个属性（一行一列的数据）
         */

        List<Employee> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class), new BigDecimal("1400"));
        query.forEach(System.out::println);
    }

    @Test
    public void test6(){

        String sql = "select max(salary) from employee";

        BigDecimal maxSalary = jdbcTemplate.queryForObject(sql, BigDecimal.class);
        System.out.println(maxSalary);
    }

    @Test
    public void test7(){

        //同Test3的插入内容相同，不同方法，这个叫具名参数插入（:xxx,:xxx而非占位符?,?）

        String sql = "insert into employee(name,salary) values (:name,:salary)";

        Map<String,Object> paramMap = new HashMap<>();

        //map的key要和具名参数名一致
        paramMap.put("name","0821,我爱你");
        paramMap.put("salary", new BigDecimal("10000"));

        namedParameterJdbcTemplate.update(sql,paramMap);

    }

    @Test
    public void test8(){

        //同Test3,Test8，插入的方法更不同
        String sql = "insert into employee(name, salary) values (:name, :salary)";

        Employee employee = new Employee(null,"国哥我爱你",new BigDecimal("6666666"));

        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
    }

    @Test
    public void test9(){

        System.out.println(employeeDao.queryEmployeeById(1));
    }

}
