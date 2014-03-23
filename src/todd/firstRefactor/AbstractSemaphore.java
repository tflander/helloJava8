package todd.firstRefactor;

public abstract class AbstractSemaphore {

	private int MAX_WAIT_IN_SECONDS = 10;
	private final String name;
	
	public AbstractSemaphore(String name) {
		this.name = name;
	}
	
	protected abstract boolean isConditionMet();
	
	public String name() {
		return name;
	}
	
	public void waitUntilDone() throws InterruptedException {
		int counter = 0;
		System.out.println("waiting for: " + name());
		while(counter++ < MAX_WAIT_IN_SECONDS) {
			if (isConditionMet()) {
				System.out.println(name() + " done.");
				return;
			}
			Thread.sleep(1000);
		}
		System.out.println(name() + " did not finish.");
		throw new IllegalStateException(name() + " did not finish.");
	}
}
