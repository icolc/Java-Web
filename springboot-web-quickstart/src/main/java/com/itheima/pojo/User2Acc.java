package com.itheima.pojo;

import java.util.Objects;


/**
 * @author NXRUI
 */
public class User2Acc {
    private String address;
    private String city;

    public User2Acc() {
    }

    public User2Acc(String address, String city) {
        this.address = address;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User2Acc user2Acc = (User2Acc) o;
        return Objects.equals(address, user2Acc.address) && Objects.equals(city, user2Acc.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city);
    }

    @Override
    public String toString() {
        return "User2Acc{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
