package com.codenvy.testtask.qname;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by mike on 22.07.14.
 */
public class ParserTest {

    static final String[] validQNames = {"prefix:name","prefix:na me","name",};
    static final String[] illegalQNames = {"",".","..","prefix:","prefix:name ","prefix: name", "pre fix:name", "name/name", "name[name", "prefix:name:name"};

    Parser parser = new Parser();

    @Test
    public void parseValidQNames(){

        QName actualQName;
        StringBuilder message = new StringBuilder();

        for (String validQName : validQNames) {
            actualQName = null;
            try {
                actualQName = parser.parse(validQName);
            } catch (IllegalNameException e) {
                message.append("\nIllegalNameException has been occured on parsing valid name \"" + validQName + "\"");
            }
            if (actualQName != null) {
                assertEquals(validQName, actualQName.getAsString());
            }
        }
    }

    @Test
    public void parseIllegalQNames() throws IllegalNameException {

        StringBuilder message = new StringBuilder();

        for (String illegalQName : illegalQNames) {
            try {
                parser.parse(illegalQName);
                message.append("\nIllegalNameException is not thrown on parsing illegal name \"" + illegalQName + "\"");
            } catch (IllegalNameException e) {

            } catch (Exception e) {
                message.append("\nUnexpected exception is thrown on parsing illegal name\"" + illegalQName + "\"");
            }
        }
        if (message.length()>0){
            fail(message.toString());
        }
    }
}
