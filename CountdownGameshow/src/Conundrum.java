import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

class Conundrum {
	static CopyOnWriteArrayList<String> dwords;
	static //List list = Collections.synchronizedList(new ArrayList()); 
	//ArrayList<String> 
	String sTarget;
	static String sShuffled;
	static Random rand;
	
	
	static ArrayList<String> uniqueWords = new ArrayList<String>();
	static int c;
	
	
public Conundrum(){
//	Conundrum c =  new Conundrum();
	dwords = importWords();
	//importWords();
	rand = new Random();
	//c = 0;
	//sTarget = null;
	sTarget = dwords.get(rand.nextInt(dwords.size()));
	sShuffled = shuffleWord(sTarget);
	//sShuffled = null;//shuffleWord(sTarget);
}

public static void findUniqueWords(){
	//synchronized(dwords){
	
	for(int i = 0;i<dwords.size();i++){
		findUniqueWord(dwords.get(i));
		System.out.println(c++);
	//}
	}
	saveUniqueSolutions();
}


public static String shuffleWord(String input){
	ArrayList<Character> chars = new ArrayList<Character>(input.length());
	for (Character c : input.toCharArray()){
		chars.add(c);
	}
	Collections.shuffle(chars);
	StringBuffer sb = new StringBuffer();
	for (Character c : chars){
		sb.append(c);
	}
 return sb.toString();
	
}

public static CopyOnWriteArrayList<String> importWords(){
	
	
	CopyOnWriteArrayList<String> words = new CopyOnWriteArrayList<String>();
	try{
	FileReader fw = new FileReader("uniquedictionary.txt");
	BufferedReader br = new BufferedReader(fw);
	
	
	while(br.ready()){
	String line = br.readLine();
	if (line.length() == 9)
		words.add(line);

	}
	br.close();
		}catch(FileNotFoundException e){
		System.err.println("File not Found, Aborting!");
		System.exit(0);
	}catch(IOException ioe){
		System.err.println(ioe);
	}
	System.out.println(words);
	System.out.println(words.size());
	return words;
}

public static void findUniqueWord(String str){
	HashMap<Character, Integer> h = new HashMap<Character, Integer>();// 9 letter words
	HashMap<Character, Integer> k = new HashMap<Character, Integer>();// input letters 
						
	//for(int i = word.length()){
	//synchronized(dwords){
		dwords.remove(str);
	//}
	ArrayList<Character> letters = new ArrayList<Character>();
	for(int i = 0;i < str.length();i++){
		letters.add(str.charAt(i));
	}
	
	ArrayList<Boolean> b = new ArrayList<Boolean>();
	ArrayList<Boolean> same = new ArrayList<Boolean>();
	
	for (char c : letters) {
		if (!k.containsKey(c)) {
			k.put(c, 1);
		} else {
			int i = k.get(c);
			k.remove(c);
			k.put(c, i + 1);
		}
	}
	//synchronized(dwords){
	for (String s : dwords) {
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
		if (b.contains(false)) {
			
			same.add(false);
		}else{
			
			same.add(true);
		}
		
		
	}
	//synchronized(dwords){
	if(!same.contains(true)){
		System.out.println("Not Same");
		addUniqueSolution(str);
	}
	dwords.add(str);
		//System.out.println(str);
	//}
	
	//}

}

public static void addUniqueSolution(String s){
//	if(c == 10000000){
//		try{
//			FileWriter fw = new FileWriter("uniquedictionary" + c + ".txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			uniqueWords.clear();
//			c = 0;
//			bw.close();
//			fw.close();
//			}catch(IOException e){
//				System.err.println(e);
//		}
//	}
	uniqueWords.add(s);
	
	//bw.append(s);
	//System.out.println(uniqueWords);
}

public static void printUniqueSolutions(){
	for(int i = 0;i < uniqueWords.size();i++){
		System.out.println(uniqueWords.get(i));
	}
	System.out.println(uniqueWords.size());
}

public static void saveUniqueSolutions(){
	try{
		FileWriter fw = new FileWriter("uniquedictionary" +c+ ".txt");
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println(uniqueWords);
		for(String s : uniqueWords){
			bw.append(s + "\n");
		}
		uniqueWords.clear();		
		bw.close();
		fw.close();
		}catch(IOException e){
			System.err.println(e);
	}
}

public static String getTargetWord(){
	dwords = importWords();
	rand = new Random();
	sTarget = dwords.get(rand.nextInt(dwords.size()));
	return sTarget;
}
public static String getShuffledWord(){
	sShuffled = shuffleWord(sTarget);
	return sShuffled;
}
public static void main(String[] args){
	//Conundrum c = new Conundrum();
	dwords = importWords();
	int r = rand.nextInt(dwords.size());
	System.out.println("Original: " + dwords.get(r));
	System.out.println("Shuffled: " + shuffleWord((dwords.get(r))));
	
	//findUniqueWord(dwords.get(r));
		
	//findUniqueWords();
}
}
