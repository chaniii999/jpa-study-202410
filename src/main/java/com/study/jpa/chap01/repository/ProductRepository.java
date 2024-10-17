package com.study.jpa.chap01.repository;


import com.study.jpa.chap01.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//jpaRepo 상속 후 첫번째 제너릭에 엔터티, 두번째에는 Pk 타입을 작성
// jpaRepository를 상속하면 자동 bean 등록됨
public interface ProductRepository extends JpaRepository<Product, Long> {

    // CRUD
}
