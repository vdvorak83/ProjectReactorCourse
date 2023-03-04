package org.course.reactive.task.lessons4;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OnError {
    public static void main(String[] args) {
        Flux.range(1, 20)
                .log()
                .map(i-> 10/(5-i))
               // .onErrorReturn(-1)
              //  .onErrorResume( e->fallback())
                .onErrorContinue((e,obj)->{

                })
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback( ){
        return Mono.fromSupplier(()->Util.faker().random().nextInt(100, 200));
    }
}
