package com.codenvy.testtask.qname;

/**
 * Created by mike on 21.07.14.
 */
public class IllegalNameException extends Exception{

    public IllegalNameException(String illegalName){
        super("Name \"" + illegalName + "\" is not valid.");
    }
}
