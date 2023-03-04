package org.course.reactive.task.lesson2;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sllepSeconds(5);
    }
}
