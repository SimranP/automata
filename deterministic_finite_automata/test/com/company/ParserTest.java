package com.company;

import org.json.simple.parser.ParseException;
import org.junit.Test;

public class ParserTest {
    @Test
    public void parse_should_parse_the_JSON_string() throws ParseException {
        Parser parser = new Parser();
        String a = "{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}";
        parser.parse(a);
        parser.tuple();
        parser.delta();
    }
}