package todd.semaphore;

public class Take5 implements Runnable {

	private int counter = 0;
	
	public void incCounter() {
		++ counter;
	}
	
	public boolean done() {
		return counter >= 5;
	}

	@Override
	public void run() {
		while (!done()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {
			}
			incCounter();
		}
		
	}

}
