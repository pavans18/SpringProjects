package multithreading;

import java.util.Random;

public class MultiThreading {

	private static final int array_size = 3;
	private static final int maxRandonNumbers = 10;
	private static int[] numbers = new int[array_size];
	private static int currentIndex = 0;                                
	private static double average = 0.0;
	private static boolean isCalculationDone = false;

	public static void main(String[] args) {

		Thread numberGeneratorThread = new Thread(() -> {
			Random random = new Random();
			for (int i = 0; i < array_size; i++) {
				numbers[i] = random.nextInt(maxRandonNumbers);
				System.out.println("Generated number: " + numbers[i]);
				currentIndex++;
			}
		});

		Thread averageCalculatorThread = new Thread(() -> {
			int sum = 0;
			while (currentIndex < array_size) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < array_size; i++) {
				sum = sum + numbers[i];
			}

			average = (double) sum / array_size;
			isCalculationDone = true;

			System.out.println("Average: " + average);

		});

		numberGeneratorThread.start();
		averageCalculatorThread.start();

		try {
			numberGeneratorThread.join();
			averageCalculatorThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}