package com.donne.temp;

import com.donne.leetcode.model.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T {

    public static void main(String[] args) {
        Object[] array;
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().forEach(r -> System.out.println(r));

        User user = new User();
        user.setName("");
        user.setAge(0);


    }


}

class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
