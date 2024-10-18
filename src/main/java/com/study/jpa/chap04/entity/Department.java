package com.study.jpa.chap04.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder

@Entity
@Table(name = "tbl_dept")
public class Department {
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "dept_name", nullable = false)
    private String name;

    // 부서번호에 해당하는 사원들의 리스트
    // 1(번호) : n(사원들)
    // employee의 "department"와 일치하는 것만 담아라.
    @OneToMany(mappedBy = "department") // employee.department = this
    private List<Employee> employees;
}
