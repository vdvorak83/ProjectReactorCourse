package org.course.reactive.task.lessons6;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SubscribeOnMultipleThreadDemo {

    public static void main(String[] args) {
        Flux<Object> flux =  Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .subscribeOn(Schedulers.newParallel("vdvorak"))
                .doOnNext(i-> printThreadName("next" + i));

        Runnable runnable = () -> flux
                .doFirst(() -> printThreadName("doFirst2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("doFirst1"))
                .subscribe(v-> printThreadName("sub" + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }


        Util.sllepSeconds(5);
    }

    public static void printThreadName(String msg){
        System.out.println(msg + "\t\t: Thread : " +Thread.currentThread().getName());
    }
}
