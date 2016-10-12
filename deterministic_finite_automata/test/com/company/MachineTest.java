package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MachineTest {
    @Test
    public void machine_should_accept_a_valid_string() {
        //machine should recognize strings which are even number in decimal representation
        HashSet<String> initial_states = new HashSet<>();
        HashSet states = new HashSet<String>();
        HashSet final_states = new HashSet<String>();
        HashSet alphabets = new HashSet<String>();
        states.add("q1");
        states.add("q2");
        final_states.add("q2");
        initial_states.add("q1");
        alphabets.add('1');
        alphabets.add('0');

        HashMap<String, HashSet<String>> tuple = new HashMap<>();
        tuple.put("final_states", final_states);
        tuple.put("states", states);
        tuple.put("initial_state", initial_states);
        tuple.put("alphabets", alphabets);

        String[][] transitions = new String[][]{new String[]{"q1,0", "q2"},
                new String[]{"q1,1", "q1"},
                new String[]{"q2,0", "q2"},
                new String[]{"q2,1", "q1"}};
        Delta delta = Delta.create(transitions);

        Machine machine = new Machine(tuple, delta);
        Assert.assertTrue(machine.play_on("10"));
        Assert.assertTrue(machine.play_on("0"));
    }

    @Test
    public void machine_should_not_accept_an_invalid_string() {
        //machine should recognize strings which are even number in decimal representation
        HashSet<String> initial_states = new HashSet<>();
        HashSet states = new HashSet<String>();
        HashSet final_states = new HashSet<String>();
        HashSet alphabets = new HashSet<String>();
        states.add("q1");
        states.add("q2");
        final_states.add("q2");
        initial_states.add("q1");
        alphabets.add('1');
        alphabets.add('0');

        HashMap<String, HashSet<String>> tuple = new HashMap<>();
        tuple.put("final_states", final_states);
        tuple.put("states", states);
        tuple.put("initial_state", initial_states);
        tuple.put("alphabets", alphabets);

        String[][] transitions = new String[][]{new String[]{"q1,0", "q2"},
                new String[]{"q1,1", "q1"},
                new String[]{"q2,0", "q2"},
                new String[]{"q2,1", "q1"}};

        Delta delta = Delta.create(transitions);

        Machine machine = new Machine(tuple, delta);
        Assert.assertFalse(machine.play_on(""));
        Assert.assertFalse(machine.play_on("1"));
    }

    @Test
    public void machine_should_not_recognize_an_alphabet_out_of_the_set_of_alphabets() {
        HashSet<String> initial_states = new HashSet<>();
        HashSet states = new HashSet<String>();
        HashSet final_states = new HashSet<String>();
        HashSet alphabets = new HashSet<String>();
        states.add("q1");
        states.add("q2");
        final_states.add("q2");
        initial_states.add("q1");
        alphabets.add('1');
        alphabets.add('0');

        HashMap<String, HashSet<String>> tuple = new HashMap<>();
        tuple.put("final_states", final_states);
        tuple.put("states", states);
        tuple.put("initial_state", initial_states);
        tuple.put("alphabets", alphabets);

        String[][] transitions = new String[][]{new String[]{"q1,0", "q2"},
                new String[]{"q1,1", "q1"},
                new String[]{"q2,0", "q2"},
                new String[]{"q2,1", "q1"}};

        Delta delta = Delta.create(transitions);

        Machine machine = new Machine(tuple, delta);
        Assert.assertFalse(machine.play_on("Q"));
    }
}