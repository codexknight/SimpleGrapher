package org.example;

public class Expr {

    public Expr(String definition) {
        parse(definition);
    }

    private void parse(String definition) {

        if (definition == null || definition.trim().equals("")) {
            error("No data provided to Expr constructor");
        }
    }

    private int pos=0, constantCt=0, codeSize = 0;

    private void error(String s) {
        throw new IllegalArgumentException("Parse error: " + s + " (Position in data = " + pos + ".");
    }
}
