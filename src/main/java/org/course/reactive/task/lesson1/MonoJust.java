package org.course.reactive.task.lesson1;

import reactor.core.publisher.Mono;

public class MonoJust {

    public static void main(String[] args) {

        //publisher
        final var mono = Mono.just(1);
        System.out.println(mono);

        mono.subscribe(i-> System.out.println("Received : " + i));
    }
}
