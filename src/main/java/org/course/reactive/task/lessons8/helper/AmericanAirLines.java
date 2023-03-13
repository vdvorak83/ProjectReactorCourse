package org.course.reactive.task.lessons8.helper;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class AmericanAirLines {
    public  static Flux<String> getFligths(){
        return Flux.range(1, Util.faker().random().nextInt(1, 10))
                .map(i-> "AA "+ Util.faker().random().nextInt(100, 999))
                .filter(i->Util.faker().random().nextBoolean());
    }
}
