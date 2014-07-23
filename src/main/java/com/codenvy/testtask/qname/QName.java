package com.codenvy.testtask.qname;

/**
 * Created by mike on 21.07.14.
 */
public class QName {

    private final String prefix;
    private final String localName;

    public QName(String name){
        String[] splittedName = name.split(":");

        if (splittedName.length == 2){
            this.prefix = splittedName[0];
            this.localName = splittedName[1];
        } else {
            this.prefix = null;
            this.localName = splittedName[0];
        }
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
