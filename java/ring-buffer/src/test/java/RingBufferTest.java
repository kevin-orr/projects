import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Thanks to exercism.io for this unit test - I've changed the name to suit.
 */

public class RingBufferTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void readingFromEmptyBufferShouldThrowException() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(1);

        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Ignore("Remove to run test")
    @Test
    public void canReadItemJustWritten() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read(), is(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void canReadItemOnlyOnce() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read(), is(1));

        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Ignore("Remove to run test")
    @Test
    public void readsItemsInOrderWritten() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        assertThat(buffer.read(), is(1));
        assertThat(buffer.read(), is(2));
    }

    @Ignore("Remove to run test")
    @Test
    public void fullBufferCantBeWrittenTo() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(1);

        buffer.write(1);
        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to write to full buffer");
        buffer.write(2);
    }

    @Ignore("Remove to run test")
    @Test
    public void readFreesUpSpaceForWrite() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read(), is(1));
        buffer.write(2);
        assertThat(buffer.read(), is(2));
    }

    @Ignore("Remove to run test")
    @Test
    public void maintainsReadPositionAcrossWrites() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(3);

        buffer.write(1);
        buffer.write(2);
        assertThat(buffer.read(), is(1));
        buffer.write(3);
        assertThat(buffer.read(), is(2));
        assertThat(buffer.read(), is(3));
    }

    @Ignore("Remove to run test")
    @Test
    public void cantReadClearedItems() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Ignore("Remove to run test")
    @Test
    public void clearFreesUpCapacity() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        buffer.write(2);
        assertThat(buffer.read(), is(2));
    }

    @Ignore("Remove to run test")
    @Test
    public void clearDoesNothingOnEmptyBuffer() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(1);

        buffer.clear();
        buffer.write(1);
        assertThat(buffer.read(), is(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void overwriteActsLikeWriteOnNonFullBuffer() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(2);

        buffer.write(1);
        buffer.overwrite(2);
        assertThat(buffer.read(), is(1));
        assertThat(buffer.read(), is(2));
    }

    @Ignore("Remove to run test")
    @Test
    public void overwriteRemovesOldestElementOnFullBuffer() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        buffer.overwrite(3);
        assertThat(buffer.read(), is(2));
        assertThat(buffer.read(), is(3));
    }

    @Ignore("Remove to run test")
    @Test
    public void overwriteDoesntRemoveAnAlreadyReadElement() throws BufferIOException {
        RingBuffer<Integer> buffer = new RingBuffer<>(3);

        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        assertThat(buffer.read(), is(1));
        buffer.write(4);
        buffer.overwrite(5);
        assertThat(buffer.read(), is(3));
        assertThat(buffer.read(), is(4));
        assertThat(buffer.read(), is(5));
    }
}
