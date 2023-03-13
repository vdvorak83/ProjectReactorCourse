package org.course.reactive.task.lessons10;

import java.util.concurrent.atomic.AtomicInteger;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class Repeat {

private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {

      /*  getIntegers()
                .subscribe(Util.subscriber());*/

        //Repeat
        getIntegers()
                //.repeat(2)
                //.repeat() recursive
                .repeat(()->atomicInteger.get() < 14)
                .subscribe(Util.subscriber());

    }


    private static Flux<Integer> getIntegers(){
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribeed : " + s))
                .doOnComplete(()-> System.out.println("---Completed"))
                .map(i -> atomicInteger.getAndIncrement()) ; //increament
               // .map(i->i/0);//error signail
    }


}
