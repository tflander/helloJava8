package todd.lambda;

import static org.junit.Assert.*;

import org.junit.Test;

public class LambdaSemaphoreTest {
		
	@Test
	public void testName() throws Exception {
		Semaphore trueSemaphore = new Semaphore("alwaysTrue", () -> true);
		Semaphore falseSemaphore = new Semaphore("alwaysFalse", () -> false);
		
		trueSemaphore.waitUntilDone();
		falseSemaphore.waitUntilDone();
	}
	

}
