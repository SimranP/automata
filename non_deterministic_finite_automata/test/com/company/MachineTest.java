package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.HashMap;
import java.util.HashSet;

public class MachineTest {
    private Machine machine;

    @Before
    public void initialize() {
        HashSet<String> initial_states = new HashSet<>();
        HashSet states = new HashSet<String>();
        HashSet final_states = new HashSet<String>();
        HashSet alphabets = new HashSet<String>();
        states.add("q1");
        states.add("q2");
        states.add("q3");
        final_states.add("q1");
        initial_states.add("q1");
        initial_states.add("q3");
        alphabets.add('a');
        alphabets.add('b');

        HashMap<String, HashSet<String>> tuple = new HashMap<>();
        tuple.put("final_states", final_states);
        tuple.put("states", states);
        tuple.put("initial_state", initial_states);
        tuple.put("alphabets", alphabets);

        HashSet<String[]> transitions = new HashSet<>();
        transitions.add(new String[]{"q1,b", "q2"});
        transitions.add(new String[]{"q3,a", "q1,q3"});
        transitions.add(new String[]{"q2,b", "q3"});
        transitions.add(new String[]{"q2,a", "q2,q3"});
        Delta delta = Delta.create(transitions);

        machine = new Machine(tuple, delta);
    }

    @Test
    public void machine_should_accept_a_valid_string() {
        //machine should recognize strings which are even number in decimal representation
        Assert.assertTrue(machine.play_on("bba"));
        Assert.assertTrue(machine.play_on("a"));
        Assert.assertTrue(machine.play_on("aab"));
    }

    @Test
    public void machine_should_not_accept_an_invalid_string() {
        //machine should recognize strings which are even number in decimal representation

        Assert.assertFalse(machine.play_on(""));
        Assert.assertFalse(machine.play_on("1"));
    }

    @Test
    public void machine_should_not_recognize_an_alphabet_out_of_the_set_of_alphabets() {
        Assert.assertFalse(machine.play_on("Q"));
    }
}