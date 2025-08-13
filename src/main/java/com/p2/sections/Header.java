package com.p2.sections;

public class Header {
    private final String logo;
    private final String client;

    public Header(String logo, String client) {
        this.logo = logo;
        this.client = client;
    }

    public void mostrar() {
        System.out.println("[Portada] Logo: " + logo + ", Cliente: " + client);
    }
}
