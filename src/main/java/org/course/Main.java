package org.course;

import reactor.core.publisher.Flux;

public class Main {
    public static void main(String[] args) {




        Flux<Object> flux = Flux.create(fluxSink -> {
                    System.out.println("created");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                     fluxSink.complete();
                })
                .publish()
                .refCount(2);
        flux.subscribe(System.out::println);
        flux.subscribe(System.out::println);
        flux.subscribe(System.out::println);
    }
}