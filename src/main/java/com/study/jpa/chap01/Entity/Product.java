package com.study.jpa.chap01.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter @ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity @Setter
@Table(name = "tbl_product")
public class Product {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @Column(name = "product_id")
    private Long id;

    @Column(name = "prod_nm", length = 30, nullable = false)
    private String name;

    @Column(name = "prod_price")
    private int price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Enum 타입은 String으로 세팅해줘~
    private Category category;

    @CreationTimestamp // Insert 시 시간 저장
    @Column(updatable = false) // 변경 불가!!
    private LocalDateTime createAt;

    @UpdateTimestamp // update 시 시간 저장
    private LocalDateTime updateAt;

    @Transient // DB에는 저장하지않겠다. (클래스 내부에서만 사용할 거임)
    private String nickname;

    public enum Category {
        FOOD,
        FASHION,
        ELECTRONIC
    }



}
