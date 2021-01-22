package com.example.springboot.controllers;

import com.example.springboot.entity.CouponEntity;
import com.example.springboot.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coupon")
public class CustomerController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/create")
    public String createCoupon(@RequestBody CouponEntity couponEntity) {
        return couponService.createCoupon(couponEntity);
    }

    @PostMapping("/redeem")
    public Object redeemCoupon(@RequestBody CouponEntity couponEntity) {
        return couponService.redeemCoupon(couponEntity);
    }
}
