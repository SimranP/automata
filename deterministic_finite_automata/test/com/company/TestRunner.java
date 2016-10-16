package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestRunner {
    @Test
    public void should_run_pass_cases_and_fail_cases_for_machine_of_each_json_object() throws IOException, ParseException {
        String jsonData = readFile("examples.json");
        Object jsonObjects = new JSONParser().parse(jsonData);

        Parser parser = new Parser();
        ArrayList<JSONObject> parse = parser.parse((String) jsonObjects);
        for (JSONObject dfa_ingredients : parse) {
            Machine machine = new Machine(parser.tuple(((JSONObject) dfa_ingredients.get("tuple"))),
                    parser.delta(((JSONObject) dfa_ingredients.get("tuple"))));
            JSONArray pass_cases = (JSONArray) dfa_ingredients.get("pass-cases");
            JSONArray fail_cases = (JSONArray) dfa_ingredients.get("fail-cases");
            should_pass(pass_cases,machine);
            should_fail(fail_cases,machine);
        }
    }

    private String readFile(String filename) throws IOException {
        return new BufferedReader(new FileReader(filename)).readLine();
    }

    private void should_fail(JSONArray fail_cases, Machine machine) {
        for (Object fail_case: fail_cases) {
            machine.reset();
            Assert.assertFalse(machine.play_on(fail_case.toString()));
        }
    }

    private void should_pass(JSONArray pass_cases, Machine machine) {
        for (Object pass_case: pass_cases) {
            machine.reset();
            Assert.assertTrue(machine.play_on(pass_case.toString()));
        }
    }
};

