package com.study.jpa.chap04.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder

@Entity
@Table(name = "tbl_student")
public class Department {
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "dept_name", nullable = false)
    private String name;
}
