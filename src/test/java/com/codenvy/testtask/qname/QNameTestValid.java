package com.codenvy.testtask.qname;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class QNameTestValid {

    public String name;

    public Parser parser;

    @Parameterized.Parameters(name= "parse valid name:\"{0}\"")
    public static List<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"prefix:name"}, {"name"}, {"prefix:na me"}
        });
    }

    public QNameTestValid(String name) {
        this.name=name;
    }

    @Before
    public void init() {
        parser = new Parser();
    }

    @Test
    public void parseValidNames() {
        try {
            QName qName = parser.parse(name);
            Map<String, String> map = parser.getSplittedName(name);
            assertEquals("Invalid prefix",map.get("prefix"),qName.getPrefix());
            assertEquals("Invalid localName",map.get("localName"),qName.getLocalName());
        } catch (IllegalNameException e) {
            fail("IllegalNameException is thrown while parsing valid name \"" + name + "\"");
        }
    }

    @Test
    public void getSplittedNamePrefixed() {
        Map<String, String> splittedName = parser.getSplittedName("prefixed:name");
        assertEquals("Unexpected prefix!", "prefixed", splittedName.get("prefix"));
        assertEquals("Unexpected localName!", "name", splittedName.get("localName"));
    }

    @Test
    public void getSplittedNameNotPrefixed() {
        Map<String, String> splittedName = parser.getSplittedName("notprefixedname");
        assertNull("Prefix is not null!", splittedName.get("prefix"));
        assertEquals("Unexpected localName!", "notprefixedname", splittedName.get("localName"));
    }

    @Test
    public void getAsStringPrefixed() {
        QName qName = new QName("prefixed", "name");
        assertEquals("","prefixed:name",qName.getAsString());
    }

    @Test
    public void getAsStringNotPrefixed() {
        QName qName = new QName(null, "notprefixedname");
        assertEquals("","notprefixedname",qName.getAsString());
    }
}
