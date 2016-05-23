package thread.main.waitandnotify;

public class Waiter implements Runnable {

	private Message msg;

	public Waiter(Message m) {
		this.msg = m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(name + " waiting to get notified at time:"
						+ System.currentTimeMillis());
				msg.wait();
				System.out.println("After wait what will happen");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}