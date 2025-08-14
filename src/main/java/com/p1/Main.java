package com.p1;

class Main {

  public static void main(String[] args) {
    // Client 1:
    new EmailNotifier(new SlackNotifier(new ConcreteComponentNotifier())).send("Order client 1 completed");

    // Client 2:
    new WhatsappNotifier(new SmsNotifier(new ConcreteComponentNotifier())).send("Order client 2 completed");
  }
}


