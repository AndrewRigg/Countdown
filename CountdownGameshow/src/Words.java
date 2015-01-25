import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

class Words {

	static ArrayList<Character> letters = new ArrayList<Character>();
	static ArrayList<String> words = new ArrayList<String>();
	static ArrayList<String> matching_words = new ArrayList<String>();

	static String randomLetters;
	static StringBuffer sb;

	static HashMap<Integer, Character> consonants = new HashMap<Integer, Character>();
	static HashMap<Integer, Character> vowels = new HashMap<Integer, Character>();

	static HashSet<String> swords = new HashSet<String>();

	static int checked_counter;

	static WordsGUI g = null;

	static double[] freqs = new double[26];

	static Random rand = new Random();

	Words(WordsGUI g) {

		randomLetters = " ";
		checked_counter = 0;

		Words.g = g;
		importWords();
		freqs[0] = 8.167;
		freqs[1] = 9.659;
		freqs[2] = 12.441;
		freqs[3] = 16.694;
		freqs[4] = 29.396;
		freqs[5] = 31.624;
		freqs[6] = 33.639;
		freqs[7] = 39.733;
		freqs[8] = 46.699;
		freqs[9] = 46.852;
		freqs[10] = 47.624;
		freqs[11] = 51.649;
		freqs[12] = 54.055;
		freqs[13] = 60.804;
		freqs[14] = 68.306;
		freqs[15] = 70.235;
		freqs[16] = 70.33;
		freqs[17] = 76.317;
		freqs[18] = 82.644;
		freqs[19] = 91.7;
		freqs[20] = 94.458;
		freqs[21] = 95.436;
		freqs[22] = 97.796;
		freqs[23] = 97.946;
		freqs[24] = 99.92;
		freqs[25] = 100;
	}

	public static void importWords() {
		try {
			FileReader fw = new FileReader("dictionary.txt");
			BufferedReader br = new BufferedReader(fw);

			while (br.ready()) {
				String line = br.readLine();
				if (line.length() < 10)
					words.add(line);

			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found, Aborting!");
			System.exit(0);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}

	}
	
	public static void easyWordSearch() {
		importWords();
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();// dictionary
																			// words
		HashMap<Character, Integer> k = new HashMap<Character, Integer>();// input
																			// letters

		ArrayList<Boolean> b = new ArrayList<Boolean>();
		for (char c : letters) {
			if (!k.containsKey(c)) {
				k.put(c, 1);
			} else {
				int i = k.get(c);
				k.remove(c);
				k.put(c, i + 1);
			}
		}
		for (String s : words) {
			h.clear();
			b.clear();
			for (char c : s.toCharArray()) {

				if (!h.containsKey(c)) {
					h.put(c, 1);
				} else {
					int i = h.get(c);
					h.remove(c);
					h.put(c, i + 1);
				}
			}
			for (Entry<Character, Integer> entry : h.entrySet()) {
				if (k.containsKey(entry.getKey())
						&& k.get(entry.getKey()).equals(entry.getValue())) {
					b.add(true);
				} else {
					b.add(false);
				}
			}
			if (!b.contains(false)) {
				addSolution(s);
			}
		}

		WordsGUI.printSolutions();
	}

	static void sortSolutions() {

		HashMap<String, Integer> words = new HashMap<String, Integer>();
		ArrayList<String> newSolutions = new ArrayList<String>();
		for (String word : swords) {
			words.put(word, word.length());
		}
		for (int i = 9; i > 2; i--) {

		}

	}

	static void addSolution(String sol) {
		swords.add(sol);
	}

	static HashSet<String> getSolutions() {
		return swords;
	}

	public static String arraytoString(ArrayList<Character> l) {
		StringBuffer sb = new StringBuffer();

		for (char c : l) {
			sb.append(c + "");
			// i++;
		}
		return sb.toString();
	}

	public static String getDictionaryWord(int index) {

		importWords();

		return words.get(index);
	}

	public static void addLetter(char letter) {
		letters.add(letter);
	}

	public static void clearLetters() {
		letters.clear();
	}

	public static void showLetters() {
		System.out.println(letters);
	}

	public static void removeLetter(int index) {

		letters.remove(index);
	}
	
	public static void setLetters(char c) {
		randomLetters += c;
		letters.add(c);
	}

	public static char randomConsonant() {
		consonants.put(0, 'b');
		consonants.put(1, 'c');
		consonants.put(2, 'd');
		consonants.put(3, 'f');
		consonants.put(4, 'g');
		consonants.put(5, 'h');
		consonants.put(6, 'j');
		consonants.put(7, 'k');
		consonants.put(8, 'l');
		consonants.put(9, 'm');
		consonants.put(10, 'n');
		consonants.put(11, 'p');
		consonants.put(12, 'q');
		consonants.put(13, 'r');
		consonants.put(14, 's');
		consonants.put(15, 't');
		consonants.put(16, 'v');
		consonants.put(17, 'w');
		consonants.put(18, 'x');
		consonants.put(19, 'y');
		consonants.put(20, 'z');
		return consonants.get((int) (Math.random() * 20));
	}

	public static HashMap<Integer, Character> getConsonants() {
		consonants.put(0, 'b');
		consonants.put(1, 'c');
		consonants.put(2, 'd');
		consonants.put(3, 'f');
		consonants.put(4, 'g');
		consonants.put(5, 'h');
		consonants.put(6, 'j');
		consonants.put(7, 'k');
		consonants.put(8, 'l');
		consonants.put(9, 'm');
		consonants.put(10, 'n');
		consonants.put(11, 'p');
		consonants.put(12, 'q');
		consonants.put(13, 'r');
		consonants.put(14, 's');
		consonants.put(15, 't');
		consonants.put(16, 'v');
		consonants.put(17, 'w');
		consonants.put(18, 'x');
		consonants.put(19, 'y');
		consonants.put(20, 'z');
		return consonants;
	}

	public static HashMap<Integer, Character> getVowels() {
		vowels.put(0, 'a');
		vowels.put(1, 'e');
		vowels.put(2, 'i');
		vowels.put(3, 'o');
		vowels.put(4, 'u');
		return vowels;
	}
	
	public static ArrayList<String> findBestWords(int a) {
		int n = a;

		HashMap<String, Integer> w = new HashMap<String, Integer>();

		for (String s : swords) {
			w.put(s, s.length());
		}

		ArrayList<String> sols = new ArrayList<String>();

		int k = 0;

		for (Entry<String, Integer> entry : w.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			if (value == n) {

				sols.add(key);
				k++;
			}

		}

		if (k < 10 && n > 1) {
			n--;
			sols.addAll(findBestWords(n));
		}

		return sols;
	}

	public static char randomVowel() {

		vowels.put(0, 'a');
		vowels.put(1, 'e');
		vowels.put(2, 'i');
		vowels.put(3, 'o');
		vowels.put(4, 'u');
		return vowels.get((int) (Math.random() * 4));

		// freqs[0] = 8.167;
		// freqs[1] = 9.659;
		// freqs[2] = 12.441;
		// freqs[3] = 16.694;
		// freqs[4] = 29.396;
		// freqs[5] = 31.624;
		// freqs[6] = 33.639;
		// freqs[7] = 39.733;
		// freqs[8] = 46.699;
		// freqs[9] = 46.852;
		// freqs[10] = 47.624;
		// freqs[11] = 51.649;
		// freqs[12] = 54.055;
		// freqs[13] = 60.804;
		// freqs[14] = 68.306;
		// freqs[15] = 70.235;
		// freqs[16] = 70.33;
		// freqs[17] = 76.317;
		// freqs[18] = 82.644;
		// freqs[19] = 91.7;
		// freqs[20] = 94.458;
		// freqs[21] = 95.436;
		// freqs[22] = 97.796;
		// freqs[23] = 97.946;
		// freqs[24] = 99.92;
		// freqs[25] = 100;
		//
		//
		// double r = rand.nextDouble()*100;
		// char sol = 0;
		// for(int i = 0; i < 25; i++){
		// if(freqs[i] < r && r < freqs[i+1] ){
		// sol = (char)(i + 97);
		// }
		// }
		// return sol;
	}

	public int getNoChars() {
		return randomLetters.length();
	}

	public boolean findMatch(String rletters, String dword) {
		int len = getNoChars();
		boolean match = false;
		for (int p = 0; p < len; p++) {
			if (letters.get(p) == dword.charAt(p)) {
				match = true;

			}
		}
		return (match == true);

	}

	public static void main(String[] argz) {

		importWords();

	}

	static String findBestWord() {
		String best = "";

		for (String s : swords) {
			if (s.length() > best.length()) {
				best = s;
			}
			if (s.length() == best.length()) {

			}
		}
		return best;
	}

}
