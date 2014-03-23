package todd.lambda;

public class Semaphore {
	
	private int MAX_WAIT_IN_SECONDS = 10;
	
	public interface ConditionMet {
		public boolean isConditionMet();
	}

	private final ConditionMet checkCondition;
	private final String name;
	
	public Semaphore(String name, ConditionMet isConditionMet) {
		this.name = name;
		this.checkCondition = isConditionMet;
	}

	public String name() {
		return name;
	}
	
	public void waitUntilDone() throws InterruptedException {
		int counter = 0;
		System.out.println("waiting for: " + name());
		while(counter++ < MAX_WAIT_IN_SECONDS) {
			if (checkCondition.isConditionMet()) {
				System.out.println(name() + " done.");
				return;
			}
			Thread.sleep(1000);
		}
		System.out.println(name() + " did not finish.");
		throw new IllegalStateException(name() + " did not finish.");
	}	
}
