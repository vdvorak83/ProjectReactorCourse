package org.course.reactive.task.lessons4;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class HandleAssignment {
    public static void main(String[] args) {


        Flux.generate(synchronousSynk-> synchronousSynk.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if(s.toLowerCase().equals("canada"))
                        synchronousSink.complete();
                })
                .subscribe(Util.subscriber());
    }
}
