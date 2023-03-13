package org.course.reactive.task.lessons11.assignment;

import java.util.function.Consumer;

public class SlackMember {

    private String name;
    private Consumer<String> messageConsumer;


    public SlackMember(String name) {
        this.name = name;
    }

    //public
    //package
    String getName() {
        return name;
    }


    public void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }

    //recievers
    //public
    //package
    void recievers(String message){
        System.out.println(message);
    }

    //says
    public  void says(String message){
      this.messageConsumer.accept(message);
    }
}
