package com.sumus.list;

import java.util.Optional;

/**
 * Created by kevinorr on 01/05/2018.
 *
 * Manages a pair of primitive, possibly nullable, types.
 *
 * Not supporting iterable types as they make it difficult to keep this Pair immutable.
 * Returning a ref to a list could allow the original list to be changed for example.
 * Could use clone but then difficult to detect if it's supported on the generic type A and/or B.
 * So safer to keep this to pairs of "primitive" types
 *
 */
class Pair<A, B> {

    private final Optional<A> a;
    private final Optional<B> b;

    public static <A, B> Pair<A, B> of(A a, B b) {
        // we'll allow null iterable types as you can't really do anything with a null list or collection value
        if (isIterableType(a) || isIterableType(b)) throw new IllegalArgumentException("Pair<A,B> does not support iterables such as List or Collection.");
        return new Pair(a, b);
    }

    static <T> boolean isIterableType(T t) {
        return t instanceof Iterable;
    }

    private Pair(A first, B second) {
        this.a = Optional.ofNullable(first);
        this.b = Optional.ofNullable(second);
    }

    public Optional<A> a() {
        return this.a;
    }

    public Optional<B> b() {
        return this.b;
    }

    @Override
    public String toString() {
        return "Pair(" + this.a + ", " + this.b + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!a.isPresent() && !pair.a.isPresent() && !b.isPresent() && !pair.b.isPresent()) return true;


        if (a.isPresent() && !pair.a.isPresent()) return false;
        if (b.isPresent() && !pair.b.isPresent()) return false;

        if (a.isPresent() && pair.a.isPresent() && !a.get().equals(pair.a.get())) return false;
        if (b.isPresent() && pair.b.isPresent() && !b.get().equals(pair.b.get())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a.isPresent() ? a.get().hashCode() : 0;
        result = 31 * result + (b.isPresent() ? b.get().hashCode() : 0);
        return result;
    }
}
