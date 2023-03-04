package org.course.reactive.task.lesson2;

import java.util.concurrent.atomic.AtomicReference;
import org.course.reactive.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class SubscriptionFlux {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicRference =  new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("OnSubscription Recived Sub : " + subscription);
                        atomicRference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("OnNet  : "  + integer );
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("OnError  : "  + throwable.getMessage() );

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("OnComplete");
                    }
                });

        Util.sllepSeconds(3);
        atomicRference.get().request(3);
        Util.sllepSeconds(5);
        atomicRference.get().request(3);
        Util.sllepSeconds(5);
        System.out.println("going to cancel");
        atomicRference.get().cancel();
        Util.sllepSeconds(5);
        atomicRference.get().request(4);
        Util.sllepSeconds(4);
    }
}
