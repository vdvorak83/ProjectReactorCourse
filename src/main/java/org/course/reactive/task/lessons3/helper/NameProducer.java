package org.course.reactive.task.lessons3.helper;

import java.util.function.Consumer;
import org.course.reactive.util.Util;
import reactor.core.publisher.FluxSink;

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;
    /**
     * Performs this operation on the given argument.
     *
     * @param stringFluxSink the input argument
     */
    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;

    }
    public void produce() {
        String name = Util.faker().name().fullName();
        String thread = Thread.currentThread().getName();
        this.fluxSink.next(thread + " : "  + name);

    }
}
