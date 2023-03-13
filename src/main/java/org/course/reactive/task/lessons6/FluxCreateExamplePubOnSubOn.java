package org.course.reactive.task.lessons6;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxCreateExamplePubOnSubOn {

    public static void main(String[] args) {

        //Which of the following statement is correct?
        //fluxSink and map get executed in parallel thread pool

                Flux.create(fluxSink -> {
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .map(i -> i + "a")
               // .publishOn(Schedulers.boundedElastic())
                .subscribeOn(Schedulers.parallel())
                .subscribe(o->printThreadName("value : " + o));



       // Which scheduler is used for map operation in the below case?
        //boundedElastic

                Flux<Object> flux = Flux.create(fluxSink -> {
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .subscribeOn(Schedulers.boundedElastic());

        flux.subscribeOn(Schedulers.parallel())
                .map(i -> i + "a")
                .subscribe(Util.subscriber());

    //    Util.sllepSeconds(5);

    }

    public static void printThreadName(String msg){
        System.out.println(msg + " \t\t: Thread : " +Thread.currentThread().getName());
    }
}
