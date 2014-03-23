package todd.firstRefactor;


public class FailureSemaphore extends AbstractSemaphore {

	public FailureSemaphore() {
		super("This Never Works");
	}

	@Override
	protected boolean isConditionMet() {
		return false;
	}
}
