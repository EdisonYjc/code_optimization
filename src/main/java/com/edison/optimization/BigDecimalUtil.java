package com.edison.optimization;

import java.math.BigDecimal;

/**
 * 解决double运算精度丢失的问题
 * @author edison
 * @version 1.0
 * @create 2021-02-02 8:49
 **/
public class BigDecimalUtil {
    public static void main(String[] args) {
        //直接计算出现精度丢失的情况
        System.out.println(0.05 + 0.01);//0.060000000000000005
        System.out.println(1.0 - 0.42);//0.5800000000000001
        System.out.println(4.015 * 100);//401.49999999999994
        System.out.println(123.3 / 100);//1.2329999999999999
        //直接使用BigDecimal也出现精度丢失的情况
        BigDecimal a = new BigDecimal(1.01);
        BigDecimal b = new BigDecimal(1.02);
        BigDecimal c = new BigDecimal("1.01");
        BigDecimal d = new BigDecimal("1.02");
        System.out.println(a.add(b));//2.0300000000000000266453525910037569701671600341796875
        System.out.println(c.add(d));//2.03
        //优化后BigDecimal不再出现精度丢失的情况
        System.out.println(add(1.01,1.02));//2.03
    }

    public static BigDecimal add(double v1, double v2) {// v1 + v2
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    public static BigDecimal div(double v1, double v2,int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        // scale = 保留小数点后两位   ROUND_HALF_UP = 四舍五入
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }
}
