package org.course.reactive.task.lessons4;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class OperatorDecoratorHandle {



    public static void main(String[] args) {
        //handle = filter + map
        Flux<Integer> flux = Flux.range(1, 20)
                .handle(((integer, synchronousSink) -> {
                    //1
                    /*if(integer % 2 ==0)
                        synchronousSink.next(integer);
                    else
                        synchronousSink.next(integer + 'a');*/
                    if (integer == 7) {
                        synchronousSink.complete();
                    } else synchronousSink.next(integer);

                }));
                flux.subscribe(Util.subscriber());
    }

}
