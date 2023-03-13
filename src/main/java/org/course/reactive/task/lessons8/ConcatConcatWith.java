package org.course.reactive.task.lessons8;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class ConcatConcatWith {




    public static void main(String[] args) {

        Flux<String> flux1 = Flux.just("a","b");
        Flux<String> flux2 = Flux.error(new RuntimeException());
        Flux<String> flux3 = Flux.just("a","b","d","f");



       // Flux<String> flux = flux1.concatWith(flux2);
       // Flux<String> flux =  Flux.concat(flux1,flux2,flux3);
        Flux<String> flux = Flux.concatDelayError(flux1,flux2,flux3);

        flux.subscribe(Util.subscriber());


    }
}
