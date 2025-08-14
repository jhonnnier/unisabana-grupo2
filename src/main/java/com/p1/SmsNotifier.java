package com.p1;

class SmsNotifier extends BaseNotifier {

  public SmsNotifier(Notifier notifier) {
    super(notifier);
  }

  @Override
  public void send(String message) {
    super.send(message);
    notifyBySms(message);
  }

  private void notifyBySms(String message) {
    System.out.println("Notifying by SMS " + message);
  }
}
