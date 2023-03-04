package org.course.reactive.task.lesson1;

import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {
    public static void main(String[] args) {

        //subscribe
        userRepositoty(20)
                .subscribe(Util.onNext(), Util.onNext(), Util.onComplete());
    }



    //publisher
    private static Mono<String> userRepositoty(int userId){
        //1 ]
        if(userId ==1){
            return Mono.just(Util.FAKER.name().firstName());
        }else if(userId==2) {
            return  Mono.empty();//null
        }else {
            return Mono.error(new RuntimeException("Not in the allowwed range"));
        }
    }
}
