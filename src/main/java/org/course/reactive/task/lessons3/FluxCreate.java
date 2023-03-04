package org.course.reactive.task.lessons3;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxCreate {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            //1
            /* fluxSink.next(1);
             fluxSink.next(2);
             fluxSink.complete();*/
            //2
           /// Util.faker().country().name();
            //3
                  /*  for (int i = 0; i <10; i++) {
                        fluxSink.next(Util.faker().country().name());

                    }
                    fluxSink.complete();*/
            String country;
            do{
               country = Util.faker().country().name();
               fluxSink.next(country);

            }while (!country.toLowerCase().equals("canada"));
            fluxSink.complete();


        })
                .subscribe(Util.onNext());

    }
}
