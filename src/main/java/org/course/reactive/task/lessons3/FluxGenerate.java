package org.course.reactive.task.lessons3;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    System.out.println("emitting");
            synchronousSink.next(Util.faker().country().name()); //1
           // synchronousSink.next(Util.faker().country().name()); //error
            synchronousSink.complete(); //invoke complete
           // synchronousSink.error(new RuntimeException("oops")); //invoke error
        })
                .take(2)//canceled
                .subscribe(Util.subscriber());
    }
}
