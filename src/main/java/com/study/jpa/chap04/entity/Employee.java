package com.study.jpa.chap04.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter @Getter
@ToString(exclude = "department") // 여러개일때 {} 안에 작성
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder

@Entity
@Table(name = "tbl_emp")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "emp_name", nullable = false)
    private String name;
    // 실무에서는 LAZY만 씀 ㅋ (맨날 갖고오면 낭비심함0
    @ManyToOne(fetch = FetchType.LAZY) // 조회 요청할때만 조인해라.
    @JoinColumn(name = "dept_id") // fk 컬럼명
    private Department department;

    // 실제 테이블의 데이터를 맞춰줘야함.
    public void changeDepartment(Department department) {
        this.department = department; // 내 테이블에서 맞추기
        department.getEmployees().add(this); // department 에 employee 추가
    }
}
