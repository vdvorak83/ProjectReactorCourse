package org.course.reactive.task.lessons3;

import org.course.reactive.task.lessons3.helper.NameProducer;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable =  nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();

        }
        Util.sllepSeconds(2);
    }
}
