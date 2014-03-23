package todd.firstRefactor;

import todd.semaphore.Take5;


public class TakeFiveSemaphore extends AbstractSemaphore {

	private Take5 take5;

	public TakeFiveSemaphore(Take5 take5) {
		super("take five semaphore");
		this.take5 = take5;
	}
	
	@Override
	protected boolean isConditionMet() {
		return take5.done();
	}
}
