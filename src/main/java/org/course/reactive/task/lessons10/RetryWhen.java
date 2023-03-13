package org.course.reactive.task.lessons10;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

public class RetryWhen {

private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {


        getIntegers()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3)))
                .subscribe(Util.subscriber());

        Util.sllepSeconds(60);

    }


    private static Flux<Integer> getIntegers(){
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribeed : " + s))
                .doOnComplete(()-> System.out.println("---Completed"))
               // .map(i->i/0)//error signail
                .map(i -> i / (Util.faker().random().nextInt(1, 5) > 3 ? 0 : 1))//error signail
                .doOnError(err -> System.out.println("--error : " + err.getMessage()));
    }


}
