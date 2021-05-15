package org.example;

import org.example.entity.Department;
import org.example.mapper.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Hello {
    public static void main(String[] args) throws Exception {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departmentList = departmentMapper.findAll();
        departmentList.forEach(System.out::println);
    }
}
