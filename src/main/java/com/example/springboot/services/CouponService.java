package com.example.springboot.services;

import com.example.springboot.entity.CouponEntity;
import com.example.springboot.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public String createCoupon(CouponEntity couponEntity) {
        try {
            CouponEntity coupon = couponRepository.save(couponEntity);
            return coupon.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String redeemCoupon(CouponEntity couponEntity) {
        try {
            if (couponEntity.getCouponCode() == null || couponEntity.getCouponCode().length() < 1) {
                return "Invalid couponCode";
            }
            if (couponEntity.getName() == null || couponEntity.getName().length() < 1) {
                return "Invalid coupon name";
            }
            if (couponEntity.getAmount() == null || couponEntity.getAmount() < 1) {
                return "Invalid coupon amount";
            }
            List<CouponEntity> couponList = couponRepository.findByNameAndCouponCode(couponEntity.getName(), couponEntity.getCouponCode());
            if (couponList == null) {
                return "NO_COUPON_FOUND";
            }
            CouponEntity coupon = couponList.get(0);
            if (couponEntity.getAmount() > coupon.getAmount()) {
                return "AMOUNT_EXCEED";
            }
            int diff = UtilService.compareDates(new Date(), coupon.getExpiryDate());
            if (diff > 0) {
                return "COUPON_EXPIRED";
            }
            coupon.setAmount(couponEntity.getAmount() - coupon.getAmount());
            CouponEntity couponEntity1 = couponRepository.save(coupon);
            return coupon.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
