package com.company;

import java.util.*;

public class Machine {
    private final HashMap<String, HashSet<String>> tuple;
    private Object[] state;
    private Delta delta;

    public Machine(HashMap<String, HashSet<String>> tuple, Delta delta) {
        this.delta = delta;
        this.tuple = tuple;
        this.state = tuple.get("initial_state").toArray();
    }

    public boolean play_on(String string) {
        String[] inputAlphabets = string.split("");
        HashSet<String> newStates = new HashSet<>();
        for (String alphabet : inputAlphabets) {
            for (Object state : this.state) {
                String[] result = this.delta.run(state.toString(), alphabet);
                if (result!=null) {
                    for (String newState : result) {
                        newStates.add(newState);
                    }
                }
            }
        }

        this.state = newStates.toArray();
        for (Object state : this.state) {
            if (tuple.get("final_states").contains(state.toString()))
                return true;
        }
        return false;
    }

    public void reset() {
        this.state = tuple.get("initial_state").toArray();
    }
}
