package com.example.sqldemo.dao;

import com.example.sqldemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Peng
 * Time: 2016/12/16 18:07
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
    /**
     *  通过年龄来查询
     *  方法名固定
     * @param age
     * @return
     */
    public List<Person> findByAge(Integer age);
}