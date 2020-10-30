package com.atguigu.mapper;

import com.atguigu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 29
 */
public interface StudentMapper {

    /**
     * 根据班级的编号一次性查询自己班级的所有学生信息
     * @param clazzId
     * @return
     */
    List<Student> queryStudentsByClazzId(Integer clazzId);

    /**
     * 根据班级编号查询学生 & 同时还要根据学生姓名进行二次过滤
     * @param clazzId
     * @param studentName
     * @return
     */
    List<Student> queryStudentByClazzIdAndLikeName
    (@Param("clazzId") Integer clazzId, @Param("studentName") String studentName);

}
