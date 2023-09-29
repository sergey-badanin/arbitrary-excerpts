package io.bsy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircularFifoBufferTest {

    @Test
    public void case01() {
        var cfb = new CircularFifoBuffer<Integer>(Integer.class, 1);

        Assertions.assertNull(cfb.peek());
        cfb.push(10);
        Assertions.assertEquals(10, cfb.peek());
        Assertions.assertEquals(10, cfb.pop());
        Assertions.assertNull(cfb.peek());
        Assertions.assertNull(cfb.pop());
        cfb.push(11);
        Assertions.assertEquals(11, cfb.peek());
        cfb.push(12);
        Assertions.assertEquals(12, cfb.peek());
        Assertions.assertEquals(12, cfb.pop());
        cfb.push(13);
        Assertions.assertEquals(13, cfb.peek());
    }

    @Test
    public void case02() {
        var cfb = new CircularFifoBuffer<Integer>(Integer.class, 3);

        Assertions.assertNull(cfb.peek());
        cfb.push(10); // [10, ^null, null]
        Assertions.assertEquals(10, cfb.peek());
        Assertions.assertEquals(10, cfb.pop());// [null, ^null, null]
        Assertions.assertNull(cfb.peek());
        Assertions.assertNull(cfb.pop());
        cfb.push(11);// [null, 11, ^null]
        Assertions.assertEquals(11, cfb.peek());
        cfb.push(12);// [^null, 11, 12]
        Assertions.assertEquals(11, cfb.peek());
        Assertions.assertEquals(11, cfb.pop());// [^null, null, 12]
        cfb.push(13);
        Assertions.assertEquals(12, cfb.peek());// [13, ^null, 12]
        cfb.push(14);// [13, 14, ^12]
        cfb.push(15);// [^13, 14, 15]
        Assertions.assertEquals(13, cfb.peek());
        cfb.push(16);// [16, ^14, 15]
        Assertions.assertEquals(14, cfb.peek());
        Assertions.assertEquals(14, cfb.pop());// [16, 14, ^15]
    }
}
