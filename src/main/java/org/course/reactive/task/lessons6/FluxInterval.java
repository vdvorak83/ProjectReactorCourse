package org.course.reactive.task.lessons6;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxInterval {

    public static void main(String[] args) {


        Flux.interval(Duration.ofSeconds(1))
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(o->printThreadName("next : " +o))
                .subscribe(Util.subscriber());



        Util.sllepSeconds(60);

    }

    public static void printThreadName(String msg){
        System.out.println(msg + " \t\t: Thread : " +Thread.currentThread().getName());
    }
}
