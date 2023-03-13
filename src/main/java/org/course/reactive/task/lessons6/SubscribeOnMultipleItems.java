package org.course.reactive.task.lessons6;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SubscribeOnMultipleItems {

    public static void main(String[] args) {
        Flux<Object> flux =  Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                        Util.sllepSeconds(1);
                    }

                    fluxSink.complete();

                })
                .doOnNext(i-> printThreadName("next" + i));

     //  Runnable runnable = () ->
               flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v-> printThreadName("sub" + v));

      /*  for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }*/


        flux
                .subscribeOn(Schedulers.parallel())
                .subscribe(v-> printThreadName("sub" + v));

        Util.sllepSeconds(5);
    }

    public static void printThreadName(String msg){
        System.out.println(msg + "\t\t: Thread : " +Thread.currentThread().getName());
    }
}
