package org.course.reactive.task.lesson2;

import java.util.List;
import org.course.reactive.task.lesson2.helper.NameGenerator;
import org.course.reactive.util.Util;

public class FluxVsList {

    public static void main(String[] args) {

        //wait 5 sec
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);

        //publisher
        NameGenerator.getNamesFlux(5)
                //subscriber
                //not wait 5 sec
                .subscribe(Util.onNext());
    }
}
