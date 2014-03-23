package todd.lambda;

import todd.semaphore.Take5;

public class TakeFiveSemaphore extends Semaphore {

	public TakeFiveSemaphore(Take5 take5) {
		super("take five semaphore", () -> take5.done());
	}

}
