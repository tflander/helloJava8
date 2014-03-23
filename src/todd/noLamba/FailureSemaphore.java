package todd.noLamba;


public class FailureSemaphore extends AbstractSemaphore {

	public FailureSemaphore() {
		super("This Never Works");
	}

	@Override
	public boolean isConditionMet() {
		return false;
	}
}
