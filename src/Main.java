
class MyThread extends Thread {
  int count;

  MyThread() {
    count = 0;
  }

  public void run() {
    System.out.println("MyThread starting.");
    try {
      do {
        Thread.sleep(500);
        System.out.println("In MyThread, count is " + count);
        count++;
      } while (count < 5);
    } catch (InterruptedException exc) {
      System.out.println("MyThread interrupted.");
    }
    System.out.println("MyThread terminating.");
  }
}

public class Main {
  public static void main(String args[]) {
    System.out.println("Main thread starting.");
    MyThread mt = new MyThread();
    mt.start();
    do {
      System.out.println("In main thread.");
      try {
        Thread.sleep(250);
      } catch (InterruptedException exc) {
        System.out.println("Main thread interrupted.");
      }
    } while (mt.count != 5);
    System.out.println("Main thread ending.");
  }
}