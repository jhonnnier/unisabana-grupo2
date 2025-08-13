package com.p2.sections;

public class Trends {
    private final String analysis;

    public Trends(String analysis) {
        this.analysis = analysis;
    }

    public void mostrar() {
        System.out.println("[Tendencias] " + analysis);
    }
}
