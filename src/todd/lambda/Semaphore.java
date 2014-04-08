package todd.lambda;

import java.util.function.BooleanSupplier;

public class Semaphore {
	
	private int MAX_WAIT_IN_SECONDS = 10;
	
	private final BooleanSupplier isDone;
	private final String name;
	
	public Semaphore(String name, BooleanSupplier isDone) {
		this.name = name;
		this.isDone = isDone;
	}
	
	public String name() {
		return name;
	}
	
	public void waitUntilDone() throws InterruptedException {
		int counter = 0;
		System.out.println("waiting for: " + name());
		while(counter++ < MAX_WAIT_IN_SECONDS) {
			if (isDone.getAsBoolean()) {
				System.out.println(name() + " done.");
				return;
			}
			Thread.sleep(1000);
		}
		System.out.println(name() + " did not finish.");
		throw new IllegalStateException(name() + " did not finish.");
	}	
}
