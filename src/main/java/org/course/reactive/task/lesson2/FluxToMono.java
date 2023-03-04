package org.course.reactive.task.lesson2;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxToMono {

    public static void main(String[] args) {

       Flux.range(1, 10)
               .filter(i -> i > 3)
               .next()
               .filter(i -> i >4)
               .subscribe(Util.onNext(),Util.onError(),Util.onComplete());

    }

    private static void doSomethings(Flux<String> stringFlux){

    }
}
