package org.course.reactive.util;

import com.github.javafaker.Faker;
import java.util.function.Consumer;
import org.reactivestreams.Subscriber;

public class Util {

     public static final Faker FAKER = Faker.instance();
    public static Consumer<Object> onNext(){
        return o -> System.out.println("Recived : " + o);
    }
    public static Consumer<Throwable> onError(){
        return e -> System.out.println("Error : " + e.getMessage());

    }
    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }

    public static void sllepSeconds(int seconds){
            sllepMillis(seconds * 1000 );
    }

    public static void sllepMillis(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber(){
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name){
        return new DefaultSubscriber(name);
    }

}
