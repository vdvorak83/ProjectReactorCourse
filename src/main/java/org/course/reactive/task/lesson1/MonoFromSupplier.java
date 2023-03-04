package org.course.reactive.task.lesson1;

import java.util.concurrent.Callable;
import java.util.function.Supplier;
import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;

public class MonoFromSupplier {
    public static void main(String[] args) {

        //1
        //use just only when you have data already
        Mono<String> monoJust = Mono.just(getName());


        //2
        //calculate with Supplier great Job for calculate data
        Mono<String> monoSupplier = Mono.fromSupplier(()-> getName());
        monoSupplier.subscribe(Util.onNext());

        //3
        //calculate with stringSupplier
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> monoStringSupplier= Mono.fromSupplier(stringSupplier);
        monoStringSupplier.subscribe(Util.onNext());


        //4 callable used
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(Util.onNext());



    }
    private static String getName(){
        System.out.println("Generate name ....");
        return Util.faker().name().fullName();
    }
}
