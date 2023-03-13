package org.course.reactive.task.lessons9;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WindowDuration {



    private static AtomicInteger atomicInteger = new AtomicInteger(1);


    public static void main(String[] args) {




        eventStream()
                .window(Duration.ofSeconds(2))
              //  .map(stringFlux -> saveEvents(stringFlux))
                .flatMap(stringFlux -> saveEvents(stringFlux))
                .subscribe(
                Util.subscriber()
        );

        Util.sllepSeconds(60);

    }


    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(500))
                .map(i->"event : " + i);
    }


    private static Mono<Integer> saveEvents(Flux<String> stringFlux){
        return stringFlux
                .doOnNext(event -> System.out.println("Saving : " +event))
                .doOnComplete(()-> {
                    System.out.println("Saved this batch");
                    System.out.println("-----------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));


    }
}
