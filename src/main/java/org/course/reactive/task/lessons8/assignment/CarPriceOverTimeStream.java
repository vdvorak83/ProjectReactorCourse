package org.course.reactive.task.lessons8.assignment;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class CarPriceOverTimeStream {

    public static void main(String[] args) {

        final int carPrce = 10000;

        Flux.combineLatest(monthStream(),demandStream(), (mohth,demand)-> {
            return (carPrce - (mohth * 100)) * demand;
        })
                .subscribe(Util.subscriber());

        Util.sllepSeconds(20);
    }

    private static Flux<Long> monthStream(){
        return Flux.interval(Duration.ZERO,Duration.ofSeconds(1));

    }

    private static Flux<Double> demandStream(){
        return Flux.interval(Duration.ofSeconds(3))
                .map(i-> Util.faker().random().nextInt(80, 120)/100d)
                .startWith(1d);
    }
}
