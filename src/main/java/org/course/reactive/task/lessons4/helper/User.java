package org.course.reactive.task.lessons4.helper;


import lombok.Data;
import lombok.ToString;
import org.course.reactive.util.Util;

@Data
@ToString
public class User {
    private String name;
    private int userId;

    public User(int userId) {
        this.name = Util.faker().name().fullName();
        this.userId = userId;
    }
}
