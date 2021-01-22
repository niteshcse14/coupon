package com.example.springboot.repository;

import com.example.springboot.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
    List<CouponEntity> findByNameAndCouponCode(String name, String couponCode);
}
