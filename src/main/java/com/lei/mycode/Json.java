package com.lei.mycode;

import com.lei.mycode.mybatisplus.entity.User;
import java.util.*;


import java.util.ArrayList;

public class Json {
    public static final String record_uri = "/v1/records";

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("abc");
        l.add("def");
        System.out.println(l);

        List<String> list = Arrays.asList("a","b","c");
        System.out.println(list);

        Integer[] ints = {1,2,3};
        System.out.println(ints);
        List<Integer> stringList = Arrays.asList(ints);
        System.out.println(stringList);

    }
}



