package todd.dryViolation;

import todd.semaphore.Take5;

public class Semaphores {
	
	private int MAX_WAIT_IN_SECONDS = 10;
	
	public void waitForSomethingThatTakesFiveSeconds(Take5 take5) throws InterruptedException {
		int counter = 0;
		System.out.println("waiting for thing that takes 5 seconds");
		while(counter++ < MAX_WAIT_IN_SECONDS) {
			if (take5.done()) {
				System.out.println("done.");
				return;
			}
			Thread.sleep(1000);
		}
		System.out.println("take5 did not finish.");
		throw new IllegalStateException("take5 did not finish.");
		
	}
	
	@SuppressWarnings("unused")
	public void waitForSomethingThatNeverFinishes() throws InterruptedException {
		int counter = 0;
		System.out.println("waiting for something that will time out");
		while(counter++ < MAX_WAIT_IN_SECONDS) {
			if (false) {
				System.out.println("done, execpt we won't get here");
				return;
			}
			Thread.sleep(1000);
		}
		System.out.println("it did not finish.");
		throw new IllegalStateException("it did not finish.");
		
	}

}
