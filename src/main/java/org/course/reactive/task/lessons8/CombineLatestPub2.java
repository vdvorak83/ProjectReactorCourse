package org.course.reactive.task.lessons8;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class CombineLatestPub2 {




    public static void main(String[] args) {

    Flux.combineLatest(getString(),getNumber(),
                    (s,i)-> s + i
                    )
            .subscribe(Util.subscriber());



      Util.sllepSeconds(10);


    }


    private  static Flux<String> getString(){
        return Flux.just("A","B","C","D")
                .delayElements(Duration.ofSeconds(1));
    }

    private  static Flux<Integer> getNumber(){
        return Flux.just(1,2,3,4)
                .delayElements(Duration.ofSeconds(3));
    }

}
