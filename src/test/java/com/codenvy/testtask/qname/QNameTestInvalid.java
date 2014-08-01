package com.codenvy.testtask.qname;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QNameTestInvalid {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public String name;
    public Parser parser;

    public QNameTestInvalid(String name) {
        this.name=name;
    }

    @Parameters(name= "parse invalid name:\"{0}\"")
    public static List<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                {""}, {"."}, {".."}, {"prefix:"}, {"prefix:name "}, {"prefix: name"}, {"pre fix:name"},
                {"name/name"}, {"name[name"}, {"prefix:name:name"}
        });
    }



    @Before
    public void init() {
        parser = new Parser();
    }

    @Test
    public void parseInvalidNames() throws IllegalNameException{
        exception.expect(IllegalNameException.class);
        parser.parse(name);
    }

}
