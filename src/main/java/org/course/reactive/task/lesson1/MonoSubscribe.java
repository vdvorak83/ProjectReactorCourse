package org.course.reactive.task.lesson1;

import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;

public class MonoSubscribe {

    public static void main(String[] args) {

       // publiher
      Mono<Integer>  mono =   Mono.just("ball")
              .map(String::length)
                      .map(l -> l / 0);

      //1
     // mono.subscribe();
    //2
      /*mono.subscribe(item -> System.out.println(item),
              err-> System.out.println(err.getMessage()),
              ()-> System.out.println("Completed"));
    }*/
        //3
        mono.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
