package com.p1;

public abstract class BaseNotifier implements Notifier {
  private Notifier wrappee;

  public BaseNotifier(Notifier notifier) {
    this.wrappee = notifier;
  }

  public void send(String message) {
    wrappee.send(message);
  }
}
