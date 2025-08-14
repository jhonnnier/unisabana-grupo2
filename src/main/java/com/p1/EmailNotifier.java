package com.p1;

class EmailNotifier extends BaseNotifier {

  public EmailNotifier(Notifier notifier) {
    super(notifier);
  }

  @Override
  public void send(String message) {
    super.send(message);
    notifyByEmail(message);
  }

  private void notifyByEmail(String message) {
    System.out.println("Notifying by email " + message);
  }
}
