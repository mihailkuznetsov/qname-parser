package com.codenvy.testtask.qname;

public class IllegalNameException extends Exception{

    public IllegalNameException(String illegalName){
        super("Name \"" + illegalName + "\" is not valid.");
    }
}
