package com.github.zhuo.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Java8 API Predicate 的各种使用方式
 */
public class PredicateSample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Tom", "James", "Dwight Howard");
        listFilter(names);
        listMultiFilter(names);
        listFilterPredicateAnd(names);
        listFilterPredicateOr(names);
        listFilterPredicateNegate(names);
    }

    private static void listFilterPredicateNegate(List<String> names) {
        Predicate<String> predicate1 = str -> str.contains("a");
        List<String> result = names.stream()
                .filter(predicate1.negate())
                .collect(Collectors.toList());
        System.out.println("listFilterPredicateNegate Does not contains a :" + result);
    }

    private static void listFilterPredicateOr(List<String> names) {
        Predicate<String> predicate1 = str -> str.contains("a");
        Predicate<String> predicate2 =  str -> str.length() > 5;
        List<String> result = names.stream()
                .filter(predicate1.or(predicate2))
                .collect(Collectors.toList());
        System.out.println("listFilterPredicateOr contains a or length > 5 :" + result);
    }

    private static void listFilterPredicateAnd(List<String> names) {
        Predicate<String> predicate1 = str -> str.contains("a");
        Predicate<String> predicate2 =  str -> str.length() > 5;
        List<String> result = names.stream()
                .filter(predicate1.and(predicate2))
                .collect(Collectors.toList());
        System.out.println("listFilterPredicateAnd contains a and length > 5 :" + result);
    }

    private static void listMultiFilter(List<String> names) {
        List<String> result = names.stream()
                // 此处实际使用 Predicate
                .filter(name -> name.startsWith("J"))
                .filter(name -> name.contains("c"))
                .collect(Collectors.toList());
        System.out.println("listMultiFilter 1 startsWith J and contains c :" + result);
        //如下同义
        result = names.stream()
                // 此处实际使用 Predicate
                .filter(name -> name.startsWith("J") && name.contains("c"))
                .collect(Collectors.toList());
        System.out.println("listMultiFilter 2 startsWith J and contains c :" + result);
    }

    private static void listFilter(List<String> names) {
        List<String> result = names.stream()
                // 此处实际使用 Predicate
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println("listFilter startsWith J :" + result);
    }

}
