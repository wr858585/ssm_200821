package com.atguigu.mapper;

import com.atguigu.pojo.Clazz;
import com.atguigu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 29
 */
public interface ClazzMapper {

    /**
     * 一次性把班级和学生所有信息，全部查询出来
     * @return
     */
    Clazz queryClazzByIdForSimple(Integer id);

    /**
     * 分两次查询，一次查班级，一次查学生。当前方法只查班级，学生用的时候再查学生
     * @param id
     * @return
     */
    Clazz queryClazzByIdForTwoSteps(Integer id);

    /**
     * 分两次查询，一次查班级，一次查学生。当前方法只查班级，学生用的时候再查学生
     * @param clazzId
     * @param studentName
     * @return
     */
    Clazz queryClazzByIdAndLikeNameForTwoSteps(@Param("clazzId") Integer clazzId, @Param("studentName") String studentName);




}
