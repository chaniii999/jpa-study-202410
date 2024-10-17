package com.study.jpa.chap02.repository;


import com.study.jpa.chap02.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByName(String name);

    List<Student> findByCityAndMajor(String city, String major);

    // major 로 찾는다, %major% 와같은
    List<Student> findByMajorContaining(String major);

    // select City where age >= ?
    List<Student> findCityByAgeGreaterThanEqual(int age);


    // native-sql
    // SELECT 컬럼명 FROM 테이블명
    // WHERE 컬럼 = ?

    // JPQL
    // SELECT 별칭 FROM 엔터티클래스명 AS 별칭
    // WHERE 별칭.필드명 = ?
    List<Student> findByNameOrCity(String name, String city);

    @Query("select st from Employee st where st.name like %?1% ")
    List<Student> serachByNameWithJPQL(String name);

    @Query("select st from Employee st where st.city = ?1 ")
    Optional<Student> getByCityWithJPQL(String city);

    @Query("delete from Employee s where s.name = ?1 and s.city = ?2 ")
    void deleteByNameAndCityWithJPQL(String name,String city);
}
