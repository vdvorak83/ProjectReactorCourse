package org.course.reactive.task.lessons8;

import org.course.reactive.task.lessons8.helper.AmericanAirLines;
import org.course.reactive.task.lessons8.helper.Emirates;
import org.course.reactive.task.lessons8.helper.QatarFlights;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class MergeAirFlights {




    public static void main(String[] args) {

      Flux<String> merge = Flux.merge(
                QatarFlights.getFligths(),
                Emirates.getFligths(),
                AmericanAirLines.getFligths()
        );


      merge.subscribe(Util.subscriber());
      Util.sllepSeconds(10);


    }
}
