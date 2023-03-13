package org.course.reactive.task.lessons8;

import org.course.reactive.task.lessons8.helper.AmericanAirLines;
import org.course.reactive.task.lessons8.helper.Emirates;
import org.course.reactive.task.lessons8.helper.QatarFlights;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class Zip {




    public static void main(String[] args) {

    Flux.zip(
              getBody(),getTiers(),getEngine()
        )
            .doOnNext(i-> System.out.println("doOnNext : " + i.toArray()))

            .subscribe(Util.subscriber());



      Util.sllepSeconds(10);


    }


    private  static Flux<String> getBody(){
        return Flux.range(1, 5)
                .map(i->"body");
    }

    private  static Flux<String> getEngine(){
        return Flux.range(1, 2)
                .map(i->"engine");
    }

    private  static Flux<String> getTiers(){
        return Flux.range(1, 6)
                .map(i->"tires");
    }
}
