package org.course.reactive.task.lessons7;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class StrategyBufferPubSubOnDemo {

    public static void main(String[] args) {

          Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                    }
                   fluxSink.complete();
                })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i-> Util.sllepMillis(10)) //bad example
                        .subscribe(Util.subscriber());



        Util.sllepSeconds(60);
    }

    public static void printThreadName(String msg){
        System.out.println(msg + " \t\t: Thread : " +Thread.currentThread().getName());
    }
}
