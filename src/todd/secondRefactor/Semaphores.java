package todd.secondRefactor;

import todd.semaphore.Take5;

public class Semaphores {

	public void waitForSomethingThatTakesFiveSeconds(Take5 take5)
			throws InterruptedException {

		new AbstractSemaphore("take five semaphore") {

			@Override
			public boolean isConditionMet() {
				return take5.done();
			}

		}.waitUntilDone();
	}

	public void waitForSomethingThatNeverFinishes() throws InterruptedException {
		new AbstractSemaphore("This Never Works") {

			@Override
			public boolean isConditionMet() {
				return false;
			}

		}.waitUntilDone();
	}
}
