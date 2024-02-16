package com.example.test;

public class DataFlags {
    private int flagID;
    private int nameID;
    private int abbreviationID;

    public DataFlags (int _flagID, int _nameID, int _abbreviationID){
        flagID = _flagID;
        nameID = _nameID;
        abbreviationID = _abbreviationID;
    }

    public int getFlagID(){
        return flagID;
    }

    public int getNameID(){
        return nameID;
    }

    public int getAbbreviationID() {
        return abbreviationID;
    }
}
