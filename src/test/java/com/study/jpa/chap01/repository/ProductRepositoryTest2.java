package com.study.jpa.chap01.repository;

import com.study.jpa.chap01.Entity.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.study.jpa.chap01.Entity.Product.Category.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductRepositoryTest2 {

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void insertBeforeTest() {
        Product p1 = Product.builder()
                .name("아이폰")
                .category(ELECTRONIC)
                .price(2000000)
                .build();
        Product p2 = Product.builder()
                .name("탕수육")
                .category(FOOD)
                .price(20000)
                .build();
        Product p3 = Product.builder()
                .name("구두")
                .category(FASHION)
                .price(300000)
                .build();
        Product p4 = Product.builder()
                .name("주먹밥")
                .category(FOOD)
                .price(1500)
                .build();
        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
    }

    @Test
    @DisplayName("저장")
    void saveTest() {
        // given
        Product p = Product.builder()
                .name("떡뽁이")
                .price(90000)
                .category(Product.Category.FASHION)
                .build();
        // when
        // insert한 객체를 가져올수있음.
        Product saved = productRepository.save(p);
        // then
        assertNotNull(saved);
    }

}