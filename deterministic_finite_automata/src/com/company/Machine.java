package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class
Machine {
    private final HashMap<String, HashSet<String>> tuple;
    private String state;
    private Delta delta;

    public Machine(HashMap<String, HashSet<String>> tuple, Delta delta) {
        this.delta = delta;
        this.tuple = tuple;
        this.state = String.valueOf(tuple.get("initial_state").toArray()[0]);
    }

    public boolean play_on(String string){
        String[] inputalphabets = string.split("");
        for (String alphabet : inputalphabets) this.state = this.delta.run(this.state, alphabet);
        return tuple.get("final_states").contains(this.state);
    }
}
