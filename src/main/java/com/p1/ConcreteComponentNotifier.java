package com.p1;

public class ConcreteComponentNotifier implements  Notifier {

  @Override
  public void send(String message) {
    System.out.println("Starting notifications " + message);
  }
}
