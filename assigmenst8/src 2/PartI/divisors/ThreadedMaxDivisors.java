package PartI.divisors;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ThreadedMaxDivisors implements Runnable {
	
	private long min;
	private long max;
	Entry<Long, Long> longLongEntry;
	
	public ThreadedMaxDivisors(long min, long max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		longLongEntry = CountDivisors.maxDivisors(min, max);
	}
	

	public static void main(String[] args) {
		
		long min = 100_000;
		long max = 200_000;


		
		Set<Thread> threadSet = new HashSet<Thread>();
		Set<ThreadedMaxDivisors> divisorsSet = new HashSet<ThreadedMaxDivisors>();
		long startTime = System.currentTimeMillis();

		long tmpMin = min;
		long tmpMax;
		int step = 1000;
		while(tmpMin < max){
			tmpMax = tmpMin + step;
			if(tmpMax>max){
				tmpMax = max;
			}
			ThreadedMaxDivisors threadedMaxDivisors = new ThreadedMaxDivisors(tmpMin, tmpMax);
			divisorsSet.add(threadedMaxDivisors);
			Thread thread = new Thread(threadedMaxDivisors);
			threadSet.add(thread);
			thread.start();
			tmpMin=tmpMax;
		}

		/* join() tells a thread to wait until it's complete before the rest of the code and proceed.
		 * if we do that for all the threads, then then we can get the results of the threads once
		 * all of them are done
		 */
		for (Thread t: threadSet) {
			try {
				t.join();
				//System.out.print("Done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// at this point, all threads have been completed, since we
		// called the "join()" method on all the threads we created,
		// which forces the code to wait until the thread is finished
		// before we continue

		long maxDivisors = 0;
		long numFound = 0;
		for (ThreadedMaxDivisors tmd : divisorsSet) {
			// presumably you've recorded the results of
			// each ThreadedMaxDivisors run. Pick
			// the largest number with the largest number of
			// divisors
			if(tmd.longLongEntry.getValue()>maxDivisors){
				numFound = tmd.longLongEntry.getKey();
				maxDivisors = tmd.longLongEntry.getValue();
			}
		}
		System.out.println("\n"+numFound + ": " + maxDivisors);
		long endTime = System.currentTimeMillis();
		System.out.println("Threaded elapsed time: " + (endTime - startTime));
		startTime = System.currentTimeMillis();
		Entry<Long,Long> e = CountDivisors.maxDivisors(min, max);
		
		long number = e.getKey();
		long numDivisors = e.getValue();
		
		System.out.println("\n" + number + ": " + numDivisors);
		endTime = System.currentTimeMillis();
		
		System.out.println("Non-threaded elapsed time: " + (endTime - startTime));
		
		
		
		
	}
}
