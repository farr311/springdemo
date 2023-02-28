package de.telran.springdemo.util.filter;


public class FilterField<T> {

    String field;
    Operation operation; //< > >= <= == != LIKE NOT LIKE
    T value;
}
