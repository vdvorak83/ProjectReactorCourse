package org.course.reactive.task.lessons9;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WindowGroupBy {



    private static AtomicInteger atomicInteger = new AtomicInteger(1);


    public static void main(String[] args) {




        Flux.range(1, 30)
                        .delayElements(Duration.ofSeconds(1))
                               // .groupBy(b->b.getColor) //key
                                .groupBy(i -> i % 2) //key 0, 1
                .subscribe(gf -> process(gf, gf.key()));




        Util.sllepSeconds(60);

    }


    private static void  process(Flux<Integer> flux, int key ){
        System.out.println("called for " + key);
       flux.subscribe(i -> System.out.println("Key : " + key + ", Item : " +i));
    }

}
