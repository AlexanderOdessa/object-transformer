package edu.javacourse.reflection;

import java.util.Date;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class Person {
    public Long id;
    public String name;
    public Date birth;

    public Person(Long id, String name, Date birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

}
