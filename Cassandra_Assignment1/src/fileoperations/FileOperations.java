package fileoperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {

	public static void main(String[] args) {

		String filename = "C://Users//spavan//OneDrive - Concentrix Corporation//Desktop//text.txt";

		int wordCount = countWordsInFile(filename);
		System.out.println("Number of words in file: " + wordCount);

		int lineCount = countLinesInFile(filename);
		System.out.println("Number of lines in file: " + lineCount);

		String longestWord = findLongestWordInFile(filename);
		System.out.println("Longest Word in file : " + longestWord);

	}

	public static int countWordsInFile(String filename) {
		int wordCount = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				wordCount += words.length;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordCount;
	}

	public static int countLinesInFile(String filename) {
		int lineCount = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			while (reader.readLine() != null) {
				lineCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineCount;
	}

	public static String findLongestWordInFile(String filename) {
		String longestWord = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					if (word.length() > longestWord.length()) {
						longestWord = word;

					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return longestWord;
	}
}
