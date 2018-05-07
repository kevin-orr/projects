package com.sumus.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Created by kevinorr on 05/05/2018.
 */
public class StreamMixer {

    /**
     * Mixes in two IntStreams and returns a mixed IntStream
     */
    static IntStream intMixer(final IntStream first, final IntStream second) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);

        /** Create an Iterator specialized for {@code int} values. */
        final PrimitiveIterator.OfInt iterator = new PrimitiveIterator.OfInt(){

            volatile boolean useItemFromFirstStream = true;
            Iterator<Integer> firstIt = first.iterator();
            Iterator<Integer> secondIt = second.iterator();

            @Override
            public boolean hasNext(){
                return firstIt.hasNext() || secondIt.hasNext();
            }

            @Override
            public int nextInt(){
                int t;
                try {
                    t = useItemFromFirstStream ? firstIt.next() : secondIt.next();
                    useItemFromFirstStream = !useItemFromFirstStream; // flip it
                } catch(java.util.NoSuchElementException noNext){
                    // we've got here as a result of one stream's limit() intermediate operation being less than the other
                    if (firstIt.hasNext()) {
                        secondIt = firstIt;
                        t = secondIt.next();
                    }
                    else {
                        firstIt = secondIt;
                        t = firstIt.next();
                    }
                }
                return t;
            }
        };
        return StreamSupport.intStream(Spliterators.spliteratorUnknownSize(
                iterator,
                Spliterator.ORDERED | Spliterator.IMMUTABLE | Spliterator.NONNULL), false);
    }
}