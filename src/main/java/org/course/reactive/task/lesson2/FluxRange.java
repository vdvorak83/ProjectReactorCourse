package org.course.reactive.task.lesson2;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxRange {
    public static void main(String[] args) {
           Flux.range(3,10)
                   .log()
                   .map(i -> Util.faker().name().fullName())
                   .log()
                  .subscribe(Util.onNext());
    }
}
