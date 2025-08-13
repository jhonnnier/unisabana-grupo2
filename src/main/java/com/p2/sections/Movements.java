package com.p2.sections;

public class Movements {
    private final String[] movements;

    public Movements(String[] movements) {
        this.movements = movements;
    }

    public void mostrar() {
        System.out.println("[Movimientos]");
        for (String mov : movements) {
            System.out.println("  - " + mov);
        }
    }
}
