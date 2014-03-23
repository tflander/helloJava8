package todd.noLambda;

import org.junit.Test;

import todd.noLamba.AbstractSemaphore;
import todd.noLamba.FailureSemaphore;
import todd.noLamba.TakeFiveSemaphore;
import todd.semaphore.Take5;

public class NoLambaSemaphoreTest {
	
	@Test (expected=IllegalStateException.class)
	public void failureSemaphoreNeverWorks() throws Exception {
		FailureSemaphore semaphore = new FailureSemaphore();
		semaphore.waitUntilDone();
	}
	
	@Test
	public void takeFiveSemaphoreFinishes() throws Exception {
		Take5 take5 = new Take5();
		new Thread(take5).start();
		TakeFiveSemaphore takeFiveSemaphore = new TakeFiveSemaphore(take5);
		takeFiveSemaphore.waitUntilDone();
	}
	
	
	@Test
	public void AnonymousSemaphoreFinishesFast() throws Exception {
		new AbstractSemaphore("Anonymous Semaphore") {
			
			@Override
			public boolean isConditionMet() {
				return true;
			}
		}.waitUntilDone();
	}

}
