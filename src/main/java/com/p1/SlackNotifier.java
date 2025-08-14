package com.p1;

class SlackNotifier extends BaseNotifier {

  public SlackNotifier(Notifier notifier) {
    super(notifier);
  }

  @Override
  public void send(String message) {
    super.send(message);
    notifyBySlack(message);
  }

  private void notifyBySlack(String message) {
    System.out.println("Notifying by slack " + message);
  }
}
