package todd.firstRefactor;

import todd.semaphore.Take5;

public class Semaphores {
	
	public void waitForSomethingThatTakesFiveSeconds(Take5 take5) throws InterruptedException {
		new TakeFiveSemaphore(take5).waitUntilDone();
	}
	
	public void waitForSomethingThatNeverFinishes() throws InterruptedException {
		new FailureSemaphore().waitUntilDone();
	}

}
