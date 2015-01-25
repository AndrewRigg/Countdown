import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class unDupe {
	
	
	public static HashSet<String> read(){
		try{
			HashSet<String> t = new HashSet<String>();
			FileReader fw = new FileReader("BIGuniquedictionary.txt");
			BufferedReader br = new BufferedReader(fw);
			
			
			while(br.ready()){
			String line = br.readLine();
			t.add(line);
			}
			br.close();
			
			return t;
				}catch(FileNotFoundException e){
				System.err.println("File not Found, Aborting!");
				System.exit(0);
			
				
			}catch(IOException ioe){
				System.err.println(ioe);
			}
		return null;
	}
	public static void write(){
		try{
			FileWriter fw = new FileWriter("BIGuniquedictionaryUNDUPED.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(String s : read()){
				bw.append(s + "\n");
			}
			
			bw.close();
			fw.close();
			}catch(IOException e){
				System.err.println(e);
		}
	}
	
	public static void main(String[] args){
		write();
	}
	
}
