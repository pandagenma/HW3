/*
Cara Holmes
CS2050
HW3
10/19/2016
*/

import java.io.*;
import java.util.*;

public class Read2City
{
    public static class Word implements Comparable<Word>
    {
	String word;
	int count;

	@Override
	public int hashCode() {
            return word.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
            return word.equals(((Word)obj).word);
	}

	@Override
	public int compareTo(Word b) {
            return b.count - count;
	}
    }

    public static void main(String[] args) throws IOException {
	Map<String, Word> countMap = new HashMap<String, Word>();
	FileReader text = new FileReader("2city10.txt");
        BufferedReader textFile = new BufferedReader(text);
	String line;
        if (textFile.ready()) {
            while ((line = textFile.readLine()) != null) {
		String[] words = line.split("[^A-ZÃ…Ã„Ã–a-zÃ¥Ã¤Ã¶]+");
                for (String word : words) {
                    if ("".equals(word)) {
                        continue;
                    }
                    
                    Word wordObj = countMap.get(word);
                    if (wordObj == null) {
                        wordObj = new Word();
                        wordObj.word = word;
                        wordObj.count = 0;
                        countMap.put(word, wordObj);
                        }
                    wordObj.count++;
                        
                }
            }
        }
		
                textFile.close();

		SortedSet<Word> sorted = new TreeSet<Word>(countMap.values());
		int i = 0;
		for (Word word : sorted) {
			if (i > 10) {
				break;
			}
			System.out.println(word.count + "\t" + word.word);
			i++;
		}
	}
}