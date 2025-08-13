package com.p2.sections;

public class Footer {
    private final String advisorName;

    public Footer(String advisorName) {
        this.advisorName = advisorName;
    }

    public void mostrar() {
        System.out.println("[Pie de página] Contacto: " + advisorName);
    }
}
