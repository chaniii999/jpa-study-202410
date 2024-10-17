package com.study.jpa.chap01.chap02.repository;

import com.study.jpa.chap02.entity.Student;
import com.study.jpa.chap02.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
class StudentRepositoryTest {

    StudentRepository studentRepository;

    @BeforeEach
    void insertData() {
        Student s1 = Student.builder()
                .name("쿠로미")
                .city("청양군")
                .major("경제학")
                .build();
        Student s2 = Student.builder()
                .name("춘식이")
                .city("서울시")
                .major("컴퓨터공학")
                .build();
        Student s3 = Student.builder()
                .name("어피치")
                .city("제주도")
                .major("화학공학")
                .build();
        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
    }

    @Test
    @DisplayName("이름으로검색")
    void fbn() {
        // given
        String name = "춘식이";
        // when
        List<Student> stds = studentRepository.findByName(name);

        // then
        String p = stds.get(0).getName();
        System.out.println("stds = " + p);
    }
}