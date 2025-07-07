package com.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

		// Producer thread
		new Thread(() -> {
			try {
				for (int i = 0; i < 5; i++) {
					String message = "Message " + i;
					queue.put(message);
					System.out.println("Produced: " + message);
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}).start();

		// Consumer thread
		new Thread(() -> {
			try {
				for (int i = 0; i < 5; i++) {
					String message = queue.take();
					System.out.println("Consumed: " + message);
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}).start();
	}
}