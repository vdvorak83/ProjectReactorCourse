package org.course.reactive.task.lessons3;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxTakeCreate {
    //map
    //filte
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3)//cancels
                .log()
                .subscribe(Util.subscriber());
    }
}
