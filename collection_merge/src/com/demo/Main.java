package com.demo;

import com.demo.util.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(0);
        list2.add(4);
        list2.add(6);
        list2.add(7);
        List<Integer> list = (List<Integer>) CollectionUtil.sortedCollectionMerge(list1, list2);
        System.out.println(list);
    }
}
