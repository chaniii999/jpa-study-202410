package com.study.jpa.chap01.repository;

import com.study.jpa.chap01.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class ProductRepositoryTest {

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("상품을 db에 저장")
    void saveTest() {
        // given
        Product p = Product.builder()
                .name("신발")
                .price(90000)
                .category(Product.Category.FASHION)
                .build();
        // when
        em.persist(p);
        // then
    }

    @Test
    @DisplayName("상품 조회")
    void selectTest() {
        // given
        long id = 2L;
        // when
        Product product = em.find(Product.class, id);
        // then
        Assertions.assertEquals("신발",product.getName());
    }

    @Test
    @DisplayName("영속성 컨텍스트의 1차 캐시 사용")
    void persistTest() {
        // given
        Product p = Product.builder()
                .name("자장면")
                .price(10000)
                .category(Product.Category.FOOD)
                .build();
        // when
        em.persist(p);
        Product findProd = em.find(Product.class, 3L);
        // then
        assertEquals(10000,findProd.getPrice());
    }

    @Test
    @DisplayName("가격수정")
    void updateTest() {
        // given
        Product shoes = em.find(Product.class, 2L);
        // when
        shoes.setPrice(90000);
        shoes.setName("나이키k");

        int price = em.find(Product.class,2L).getPrice();
        // then
        assertEquals(90000,price);
    }
}