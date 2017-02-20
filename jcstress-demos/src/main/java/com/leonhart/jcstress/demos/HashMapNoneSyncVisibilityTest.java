package com.leonhart.jcstress.demos;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@JCStressTest
@Outcome(id = "1, 0", expect = Expect.ACCEPTABLE, desc = "Ok")
@Outcome(id = "0, 0", expect = Expect.ACCEPTABLE, desc = "Ok")
@State
public class HashMapNoneSyncVisibilityTest {
   HashMap<Integer, Integer> map = new HashMap<>();

   @Actor
   public void actor1(IntResult2 r) {
      r.r1 = Optional.ofNullable(map.get(1))
                     .orElse(0);
   }

   @Actor
   public void actor2(IntResult2 r) {
      map.put(1, 1);
   }
}
