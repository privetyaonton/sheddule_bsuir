package org.example.logic;

public class UndefindedIndexException extends Exception{
    public UndefindedIndexException(String table, int id){
        super("Undefinded Index Exception in " + table + ": index = " +
                Integer.toString(id));
    }
}
