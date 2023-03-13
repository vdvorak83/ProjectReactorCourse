package org.course.reactive.task.lessons7;

import java.util.ArrayList;
import java.util.List;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

public class StrategyDrop {

    public static void main(String[] args) {


        //Queues
        //75% 12
        System.setProperty("reactor.bufferSize.small", "16");

        List<Object> list = new ArrayList<>();

          Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 1; i < 201; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                        Util.sllepMillis(1);
                    }
                   fluxSink.complete();
                })
                  .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i-> Util.sllepMillis(10)) //bad example 
                        .subscribe(Util.subscriber());



        Util.sllepSeconds(10);
        System.out.println(list);
    }

    public static void printThreadName(String msg){
        System.out.println(msg + " \t\t: Thread : " +Thread.currentThread().getName());
    }
}
