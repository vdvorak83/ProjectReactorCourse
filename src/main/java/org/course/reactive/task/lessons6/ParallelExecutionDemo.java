package org.course.reactive.task.lessons6;

import java.util.ArrayList;
import java.util.List;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ParallelExecutionDemo {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();



       /* Flux.range(1, 1000)
                .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(o -> printThreadName("next" + o))
                .subscribe(v-> list.add(v));*/

        Flux.range(1, 10)
                .parallel(10)//2 thread
                .runOn(Schedulers.boundedElastic())
                .doOnNext(o -> printThreadName("next" + o))
                .sequential() //single publisher
                .subscribe(v->printThreadName("sub" + v));



        Util.sllepSeconds(5);
       // System.out.println("sizelist : " +list.size());
    }

    public static void printThreadName(String msg){
        System.out.println(msg + " \t\t: Thread : " +Thread.currentThread().getName());
    }
}
