package com.study.jpa.chap04.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter @Getter
@ToString
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

    @ManyToOne // 포린키를 가진 사람 위주로 작성해야함.
    @JoinColumn(name = "dept_id") // fk 컬럼명
    private Department department;

}
