package org.course.reactive.task.lesson2;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxIntro {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1,2,3,4,"a",Util.faker().name().fullName()); // Flux.empty();
        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
