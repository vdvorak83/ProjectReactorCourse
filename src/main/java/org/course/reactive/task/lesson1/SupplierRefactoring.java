package org.course.reactive.task.lesson1;

import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class SupplierRefactoring {

    public static void main(String[] args) {
        getName();
       String name =  getName()
                .subscribeOn(Schedulers.boundedElastic())
                        .block();// use blocking subscribe
                //.subscribe(Util.onNext());//synchronize
       // System.out.println(name);
        getName();

        Util.sllepSeconds(4); //block for main thead
    }


    private static Mono<String> getName(){
        System.out.println("entered getName method");
       return  Mono.fromSupplier(()->{
           System.out.println("Generate name  .....");
           Util.sllepSeconds(3);
           return  Util.faker().name().fullName();
       }).map(String::toUpperCase);
    }
}
