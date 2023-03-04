package org.course.reactive.task.lesson2;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("a");

        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Util.onNext());

    }

    private static void doSomethings(Flux<String> stringFlux){

    }
}
