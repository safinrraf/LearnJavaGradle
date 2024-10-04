package com.learn.chapter17;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import lombok.extern.slf4j.Slf4j;

/**
 * A task to write a code to simultaneously run N threads.
 * the operating system's thread scheduler ultimately controls the exact start time of each thread,
 * so it's not guaranteed that they will start at the exact same moment,
 * but they will be as synchronized as possible given the constraints of the system.
 */
@Slf4j
public class SynchronizedThreadsExample {

  //the number of threads that must invoke await before the barrier is tripped
  //6 in this case
  private static final int NUMBER_OF_THREADS = 6;

  public static void main(String[] args) {
    final var barrier = new CyclicBarrier(NUMBER_OF_THREADS, () -> {
      // This task will be executed once all threads reach the barrier
      log.info("All threads have reached the barrier and will start almost simultaneously.");
    });

    for (int i = 0; i < NUMBER_OF_THREADS; i++) {
      final var thread = new Thread(new WorkerThread(barrier), "Thread " + (i + 1));
      thread.start();
    }
  }

  static class WorkerThread implements Runnable {
    private final CyclicBarrier barrier;

    public WorkerThread(CyclicBarrier barrier) {
      this.barrier = barrier;
    }

    @Override
    public void run() {
      try {
        log.info(Thread.currentThread().getName() + " is waiting at the barrier.");
        //Waits until all parties have invoked await on this barrier.
        barrier.await();
        // Perform thread's work here after all threads start
        log.info(Thread.currentThread().getName() + " has started working.");
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }
}

