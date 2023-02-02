package de.telran.springdemo.model;

public class Greeting {
    private String value;

    private int count;

    @Override
    public String toString() {
        return "Greeting{" +
                "value='" + value + '\'' +
                ", repeatCount=" + count +
                '}';
    }
}
