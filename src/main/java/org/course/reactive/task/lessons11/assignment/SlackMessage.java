package org.course.reactive.task.lessons11.assignment;

import lombok.Data;

@Data
public class SlackMessage {

    private static final String FORMAT = "[%s->%s] : %s";

    private String sender;
    private String reciver;
    private String message;

    @Override
    public String toString(){
        return
                String.format(FORMAT, this.sender,this.reciver,this.message);
    }

}
