package org.course.reactive.task.lessons4;

import java.util.function.Function;
import org.course.reactive.task.lessons4.helper.Person;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class SwitchOnFirst {

    public static void main(String[] args) {

        getPerson()
                .switchOnFirst( (signal,personFlux) -> {
                    System.out.println("inside switch-on-first");
                   return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                })

                .subscribe(Util.subscriber());


    }

    public  static Flux<Person> getPerson(){
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>,Flux<Person>> applyFilterMap(){
        return personFlux -> personFlux
                .filter(p->p.getAge()>10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, person -> System.out.println("Not allowing : " + person));
    }

}
