package com.company;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class DeltaTest {
    @Test
    public void run_should_return_the_result_state_of_given_alphabet_and_state() {
        HashSet<String[]> transitions = new HashSet<String[]>();
            transitions.add(new String[]{"q1,0", "q1"});
                transitions.add(new String[]{"q1,1", "q2"});
                transitions.add(new String[]{"q2,0", "q2"});
                transitions.add(new String[]{"q2,1", "q3"});
                transitions.add(new String[]{"q3,0", "q3"});
                transitions.add(new String[]{"q3,1", "q3"});

        Delta delta = Delta.create(transitions);
        assertEquals(delta.run("q1", "0"), "q1");
    }

    @Test
    public void create_should_return_delta_object() {
        HashSet<String[]> transitions = new HashSet<String[]>();
        transitions.add(new String[]{"q1,0", "q1"});
                transitions.add(new String[]{"q1,1", "q2"});
                transitions.add(new String[]{"q2,0", "q2"});
                transitions.add(new String[]{"q2,1", "q3"});
                transitions.add(new String[]{"q3,0", "q3"});
                transitions.add(new String[]{"q3,1", "q3"});

        Delta delta = Delta.create(transitions);
    }
}