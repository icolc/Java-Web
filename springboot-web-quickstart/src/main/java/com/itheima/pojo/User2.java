package com.itheima.pojo;

import java.util.Objects;

/**
 * @author NXRUI
 */
public class User2 {
    private String name;
    private int age;

    private User2Acc user2Acc;

    public User2() {
    }

    public User2(String name, int age, User2Acc user2Acc) {
        this.name = name;
        this.age = age;
        this.user2Acc = user2Acc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User2Acc getUser2Acc() {
        return user2Acc;
    }

    public void setUser2Acc(User2Acc user2Acc) {
        this.user2Acc = user2Acc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User2 user2 = (User2) o;
        return age == user2.age && Objects.equals(name, user2.name) && Objects.equals(user2Acc, user2.user2Acc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, user2Acc);
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", user2Acc=" + user2Acc +
                '}';
    }

}
