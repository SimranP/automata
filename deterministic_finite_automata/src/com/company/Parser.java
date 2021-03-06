package com.company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.util.*;


public class Parser {
    public ArrayList<JSONObject> parse(String json) throws ParseException {
        ArrayList<JSONObject> allObjects = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonObjects = (JSONArray) jsonParser.parse(json);
        for (Object jsonObject: jsonObjects) allObjects.add((JSONObject) jsonObject);
        return allObjects;
    }

    public HashMap<String, HashSet<String>> tuple(JSONObject jsonTuple){
        HashMap<String, HashSet<String>> tuple = new HashMap<>();
        JSONArray start_state = new JSONArray();
        start_state.add(jsonTuple.get("start-state"));
        HashSet states = convertToHashSet((JSONArray) jsonTuple.get("states"));
        HashSet final_states = convertToHashSet((JSONArray) jsonTuple.get("final-states"));
        HashSet alphabets = convertToHashSet((JSONArray) jsonTuple.get("alphabets"));
        tuple.put("final_states", final_states);
        tuple.put("states", states);
        tuple.put("initial_state",convertToHashSet(start_state));
        tuple.put("alphabets", alphabets);
        return tuple;
    }

    private HashSet<String> convertToHashSet(JSONArray array){
        HashSet<String> hashset = new HashSet<>();
        for (Object string : array) hashset.add((String) string);
        return hashset;
    }

    public Delta delta(JSONObject jsonTuple){
        HashSet<String[]> transitions = new HashSet<>();
        JSONObject delta =(JSONObject) jsonTuple.get("delta");
        for (Object key: delta.keySet()) {
            JSONObject value = (JSONObject) delta.get(key);
            for (Object inner_key: value.keySet()) {
                String[] strings = {String.format("%s,%s",key,inner_key), (String) value.get(inner_key)};
                transitions.add(strings);
            }
        }
        return Delta.create(transitions);
    };
}
