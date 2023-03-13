package org.course.reactive.task.lessons7;

import java.util.ArrayList;
import java.util.List;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Latest {

    public static void main(String[] args) {


        //Queues
        //75% 12
        System.setProperty("reactor.bufferSize.small", "16");


          Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 1; i < 201; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                        Util.sllepMillis(1);
                    }
                   fluxSink.complete();
                })
               //   .onBackpressureLatest()
                  .onBackpressureDrop()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i-> {
                    Util.sllepMillis(10);
                }) //bad example
                        .subscribe(Util.subscriber());



        Util.sllepSeconds(10);
    }

    public static void printThreadName(String msg){
        System.out.println(msg + " \t\t: Thread : " +Thread.currentThread().getName());
    }
}
