package org.course.reactive.task.lesson1;

import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;

public class MonoFromRunnable
{
    public static void main(String[] args) {


        Runnable runnable = () -> System.out.println("Runnable example ");

        Mono.fromRunnable(timeConsumingProcess()) //use runnable for watch whats different
                .subscribe(Util.onNext(),Util.onError(),
                        () ->{
                    System.out.println("process is done .Sending emails .....");
                        }
                        );
    }



     private static Runnable timeConsumingProcess(){
        return ()->{
            Util.sllepSeconds(3);
            System.out.println("Operation completed");
        };
     }

}
