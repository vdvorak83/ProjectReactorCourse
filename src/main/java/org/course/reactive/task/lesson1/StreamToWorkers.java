package org.course.reactive.task.lesson1;

import java.util.stream.Stream;

public class StreamToWorkers {

    public static void main(String[] args) {
        final var stream  = Stream.of(1).map(

                i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i * 2;
                }
        );
        stream.forEach(System.out::println);

    }
}
