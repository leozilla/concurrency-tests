package com.leonhart.jcstress.demos;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult2;


/**
 * Original test from jcstress samples
 */
@JCStressTest
@Outcome(id = "0, 0", expect = Expect.FORBIDDEN, desc = "Failure")
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Lost update")
@Outcome(id = "1, 2", expect = Expect.ACCEPTABLE, desc = "Ok")
@Outcome(id = "2, 1", expect = Expect.ACCEPTABLE, desc = "Ok")
@State
public class IntegerAtomicityTest {
    int i;

    @Actor
    public void actor1(IntResult2 r) {
       r.r1 = ++i;
    }

    @Actor
    public void actor2(IntResult2 r) {
       r.r2 = ++i;
    }
}
