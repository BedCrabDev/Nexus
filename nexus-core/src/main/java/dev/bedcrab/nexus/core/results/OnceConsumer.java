package dev.bedcrab.nexus.core.results;

import java.util.function.Consumer;

public abstract class OnceConsumer<T> implements Consumer<T> {
    public static <T> OnceConsumer<T> wrap(Consumer<T> consumer) {
        return new OnceConsumer<T>() {
            @Override
            public void once(T t) {
                consumer.accept(t);
            }
        };
    }

    protected boolean isCalled = false;

    @Override
    public Consumer<T> andThen(Consumer<? super T> after) {
        return Consumer.super.andThen(after);
    }

    @Override
    public void accept(T t) {
        if (!isCalled) {
            isCalled = true;
            once(t);
        }
        after(t);
        all(t);
    }

    protected void reset() {
        isCalled = false;
    }

    protected abstract void once(T t);
    protected void after(T t) {}
    protected void all(T t) {}
}
