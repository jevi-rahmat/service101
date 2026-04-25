package com.adib.consumer;

import java.io.Serializable;

public class MessageDTO implements Serializable {
    private String name;
    private int age;

    public MessageDTO() {}

    public MessageDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
