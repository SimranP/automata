package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeltaTest {
    @Test
    public void run_should_return_the_result_state_of_given_alphabet_and_state() {
        String[][] transitions = new String[][]{new String[]{"q1,0", "q1"},
                new String[]{"q1,1", "q2"},
                new String[]{"q2,0", "q2"},
                new String[]{"q2,1", "q3"},
                new String[]{"q3,0", "q3"},
                new String[]{"q3,1", "q3"}};

        Delta delta = Delta.create(transitions);
        assertEquals(delta.run("q1", "0"), "q1");
    }

    @Test
    public void create_should_return_delta_object() {
        String[][] transitions = new String[][]{new String[]{"q1,0", "q1"},
                new String[]{"q1,1", "q2"},
                new String[]{"q2,0", "q2"},
                new String[]{"q2,1", "q3"},
                new String[]{"q3,0", "q3"},
                new String[]{"q3,1", "q3"}};

        Delta delta = Delta.create(transitions);
    }
}