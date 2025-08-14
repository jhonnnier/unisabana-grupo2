package com.p1;

class WhatsappNotifier extends BaseNotifier {

  public WhatsappNotifier(Notifier notifier) {
    super(notifier);
  }

  @Override
  public void send(String message) {
    super.send(message);
    notifyByWhatApp(message);
  }

  private void notifyByWhatApp(String message) {
    System.out.println("Notifying by whatsapp " + message);
  }
}
