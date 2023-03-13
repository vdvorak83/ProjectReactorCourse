package org.course.reactive.task.lessons5;

import java.time.Duration;
import java.util.stream.Stream;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class HotSharePublisher {
    public static void main(String[] args) {

       Flux<String> movieStream =  Flux.fromStream(()-> getMovie()).delayElements(Duration.ofSeconds(2))
               .share();

       movieStream.subscribe(
               Util.subscriber("sam")
       );

        Util.sllepSeconds(5);

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sllepSeconds(60); //because different thread
    }
    private static Stream<String> getMovie(){
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
