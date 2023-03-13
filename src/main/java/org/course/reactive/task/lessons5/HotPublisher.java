package org.course.reactive.task.lessons5;

import java.time.Duration;
import java.util.stream.Stream;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class HotPublisher {
    public static void main(String[] args) {

        //share = publish.refcount(1);
       Flux<String> movieStream =  Flux.fromStream(()-> getMovie())
               .delayElements(Duration.ofSeconds(1))
               .publish()
               .refCount(2);


       movieStream.subscribe(
               Util.subscriber("sam")
       );

        Util.sllepSeconds(10); //10 second for see Cold Publisger 2

        movieStream.subscribe(
                Util.subscriber("mike")
        );


        movieStream.subscribe(
                Util.subscriber("jake")
        );

        Util.sllepSeconds(60); //because different thread
    }
    private static Stream<String> getMovie()
    {
        System.out.println("Got the movie streaming req");

 return Stream.of(
         "Sense 1",
         "Sense 2",
         "Sense 3",
         "Sense 4",
         "Sense 5",
         "Sense 6",
         "Sense 7"
         );
    }
}
