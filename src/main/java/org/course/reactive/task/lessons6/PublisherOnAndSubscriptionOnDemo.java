package org.course.reactive.task.lessons6;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class PublisherOnAndSubscriptionOnDemo {

    public static void main(String[] args) {
        Flux<Object> flux =  Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                    }
                   fluxSink.complete();
                })
                .doOnNext(i-> printThreadName("next" + i));

        //Runnable runnable = () ->
                flux

                .publishOn(Schedulers.parallel())
                        .doOnNext(o -> printThreadName("next" + o))
                 .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v-> printThreadName("sub" + v));


        Util.sllepSeconds(5);
    }

    public static void printThreadName(String msg){
        System.out.println(msg + " \t\t: Thread : " +Thread.currentThread().getName());
    }
}
