package todd.lambda;

import todd.semaphore.Take5;

public class Semaphores {
	
	public void waitForSomethingThatTakesFiveSeconds(Take5 take5) throws InterruptedException {
		new Semaphore("take5 semaphore", () -> take5.done()).waitUntilDone();
	}
	
	public void waitForSomethingThatNeverFinishes() throws InterruptedException {
		new Semaphore("take5 semaphore", () -> false).waitUntilDone();
	}

}
