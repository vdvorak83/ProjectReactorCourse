package org.course.reactive.task.lessons4;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class TimeoutOperator {

    public static void main(String[] args) {

        getOrderNumbers()
                .timeout(Duration.ofSeconds(2),fallback())
                .subscribe(Util.subscriber());

        Util.sllepSeconds(60);

    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallback(){
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}
