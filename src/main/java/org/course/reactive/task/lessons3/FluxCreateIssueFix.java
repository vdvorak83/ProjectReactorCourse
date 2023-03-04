package org.course.reactive.task.lessons3;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxCreateIssueFix {

    public static void main(String[] args) {

        //canada
        //max =10
        //subsciber cancel - exit

        //only one instance of fluxsink
        Flux.create(fluxSink -> {

                    String country;
                    int counter = 0;
                    do{
                        country = Util.faker().country().name();
                        System.out.println("emitting : " + country);
                        fluxSink.next(country);
                        counter++;

                    }while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled()&& counter < 10);
                   // fluxSink.isCancelled();
                   fluxSink.complete();


                })
                //.take(3)//canceled subscription
                .subscribe(Util.onNext());
    }
}
