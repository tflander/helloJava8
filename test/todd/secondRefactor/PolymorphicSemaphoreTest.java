package todd.secondRefactor;

import org.junit.Before;
import org.junit.Test;

import todd.semaphore.Take5;

public class PolymorphicSemaphoreTest {
	
	private Semaphores semaphores;

	@Before
	public void setup() {
		semaphores = new Semaphores();
	}
	
	@Test
	public void waitForSomethingThatTakesFiveSeconds() throws Exception {
		Take5 take5 = new Take5();
		new Thread(take5).start();
		semaphores.waitForSomethingThatTakesFiveSeconds(take5);
	}
	
	@Test (expected=IllegalStateException.class)
	public void waitForSomethingThatNeverFinishes() throws Exception {
		semaphores.waitForSomethingThatNeverFinishes();
	}
}
