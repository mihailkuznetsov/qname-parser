package com.codenvy.testtask.qname;

public class QName {

    private final String prefix;
    private final String localName;


    public QName(String prefix, String localName) {
        this.prefix = prefix;
        this.localName = localName;
    }

    public String getPrefix(){
        return prefix;
    }

    public String getLocalName(){
        return localName;
    }

    public String getAsString(){
        if (prefix == null){
            return getLocalName();
        } else {
            return getPrefix() + ":" + getLocalName();
        }
    }
}
