package com.company;

import java.util.HashMap;

public class Delta {
    private HashMap<String,String> transitions;

    private Delta() {
        this.transitions = new HashMap<>();
    }

    public String run(String state, String alphabet) {
        return this.transitions.get(String.format("%s,%s", state, alphabet));
    }

    public static Delta create(String[][] transitions_strings){
        Delta delta = new Delta();
        for (String[] transition : transitions_strings) delta.transitions.put(transition[0], transition[1]);
        return delta;
    }
}
