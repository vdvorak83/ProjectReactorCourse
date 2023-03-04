package org.course.reactive.task.lessons4;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class DefaultIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers().filter(i -> i >10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 12) //10 if empty
                .delayElements(Duration.ofSeconds(5));
    }
}
