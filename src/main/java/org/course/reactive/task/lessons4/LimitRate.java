package org.course.reactive.task.lessons4;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class LimitRate {

    public static void main(String[] args) {
        Flux.range(1, 1000) //175
                .log()
              //  .limitRate(100)//75 default
                //.limitRate(100,99)//99%
                //.limitRate(100,100)//75%
                .limitRate(100,0)//100%
                .subscribe(Util.subscriber());
    }
}
