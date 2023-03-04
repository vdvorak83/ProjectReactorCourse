package org.course.reactive.task.lessons3;

import java.util.concurrent.atomic.AtomicInteger;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxGenerateAssigment {

    public static void main(String[] args) {

        //canada
        //max =10
        //subsciber cancel - exit
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux.generate(synchronousSink -> {

          String country = Util.faker().country().name();
                    System.out.println("emitting : " + country);
                    synchronousSink.next(country);
                    atomicInteger.incrementAndGet();
                    if (country.toLowerCase().equals("canada")) {
                        synchronousSink.complete();
                    }

        })
                .subscribe(Util.subscriber());
        System.out.println("counter : " + atomicInteger.incrementAndGet());
    }
}
