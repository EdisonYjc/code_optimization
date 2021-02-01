package com.edison.optimization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * list 去重优化
 * @author edison
 * @version 1.0
 * @create 2021-02-01 15:56
 **/
public class ListOptimization {
    public static void main(String[] args) {
        /**
         * 模拟集合数据量
         * 数据量           优化前耗时      优化后耗时
         * 1万              47ms           10ms
         * 10万             3.7s           16ms
         * 100万            6min
         */
        int count = 100000;
        List<Integer> list = new ArrayList<>();
        for (Integer i = 0; i < count; i++) {
            list.add(i);
        }
        //优化前
        long startime1 = System.currentTimeMillis();
        List<Integer> distinctOld = distinct_old(list);
        System.out.println(count + "数据量，未优化耗时(毫秒):" + (System.currentTimeMillis() - startime1));
        //优化后
        long startime2 = System.currentTimeMillis();
        List<Integer> distinct = distinct(list);
        System.out.println(count + "数据量，优化后耗时(毫秒):" + (System.currentTimeMillis() - startime2));
    }

    /**
     * list去重(优化后)
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> distinct(List<T> list) {
        if (list == null) {
            return null;
        } else {
            List<T> result = new ArrayList<>(new HashSet<>(list));
            return result;
        }
    }

    /**
     * list去重(未优化)
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> distinct_old(List<T> list) {
        if (list == null) {
            return null;
        } else {
            List<T> result = new ArrayList<>();
            for (T item : list) {
                if (!result.contains(item)) {
                    result.add(item);
                }
            }
            return result;
        }
    }
}
