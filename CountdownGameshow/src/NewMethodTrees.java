import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author ar339 
 * Complete set of Arithmetic Solutions 
 * for Countdown Numbers Round
 */

public class NewMethodTrees {
	/**
	 * Define all fields and variables.
	 * Need set of Doubles, set of operators and set of brackets.
	 */
	ArrayList<ArrayList<Double>> varPlace = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Double>> tempVarPlace = new ArrayList<ArrayList<Double>>();
	ArrayList<ArrayList<Character>> opPlace = new ArrayList<ArrayList<Character>>();
	ArrayList<ArrayList<Character>> tempOpPlace = new ArrayList<ArrayList<Character>>();
	ArrayList<ArrayList<Character>> binTree = new ArrayList<ArrayList<Character>>();
	ArrayList<ArrayList<Character>> tempBinTree = new ArrayList<ArrayList<Character>>();
	ArrayList<String> answers = new ArrayList<String>();
	ArrayList<Double> solutions = new ArrayList<Double>();
	ArrayList<Double> var;
	ArrayList<Character> ops;
	ArrayList<Character> tree;
	public double[] variables = {0,1,5,6,7}; 
	char[] operators = { '0', '+', '-', 'x', '/' };
	int [] arrayPlaces = new int [3];
	int target = 21;
	int operatorPlace = 0;
	double s;
	String answer;
	
	public NewMethodTrees(){}
	
	public void clearAnswers(){
		answers.clear();
		solutions.clear();
	}
	
	public void setInputVariables(double[] v, int t){
		variables = v;
		target = t;
	}
	
	public String getAnswer(int index) throws NullPointerException {
		try {
			return answers.get(index);
		} catch (IndexOutOfBoundsException e) {
			return "No more solutions";
		}
	}
	/**
	 * Create an ArrayList of Doubles that contains all combinations
	 * of the input numbers with 2 - 6 values excluding repetitions.
	 */
	
	public void setVariable() {
		
			for (int i = 0; i < variables.length; i++) {
			if (i == 0)
				for (int j = 0; j < variables.length; j++) {
				if (j != i || j == 0)
					for (int k = 0; k < variables.length; k++) {
					if (k != j && k != i || k == 0)
						for (int l = 0; l < variables.length; l++) {
						if (l != k && l != j && l != i || l == 0)
							for (int m = 0; m < variables.length; m++) {
							if (m != l && m != k && m != j && m != i || m == 0)
								for (int n = 0; n < variables.length; n++) {
								if (n != m && n != l && n != k && n != j && n != i || n == 0) {
									var = new ArrayList<Double>();
									if (i != 0)
										var.add(variables[i]);
									if (j != 0)
										var.add(variables[j]);
									if (k != 0)
										var.add(variables[k]);
									if (l != 0)
										var.add(variables[l]);
									if (m != 0)
										var.add(variables[m]);
									if (n != 0)
										var.add(variables[n]);
									if (!varPlace.contains(var)&& var.size() > 1) {
										varPlace.add(var);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	

	/**
	 * Create a duplicate ArrayList of variables that can be manipulated later.
	 */
	
	public void setTempVariable(){
		ArrayList<Double> tempALi;
		for(ArrayList<Double> t : varPlace){
			tempALi  = new ArrayList<Double>();
			for(Double i : t){
				double iI = i;
				tempALi.add(iI);	
			}
			tempVarPlace.add(tempALi);
		}
	}
	
	/**
	 * reset the variables that were used in the last iteration of the
	 * operation to allow them to be manipulated in the next iteration
	 * @param x
	 */
	
	public void resetCurrentVariable(int x){
		ArrayList<Double> temp1;
		temp1 = new ArrayList<Double>();
		for (Double i : varPlace.get(x)){
			double i2 = i;
			temp1.add(i2);
		}
		tempVarPlace.set(x, temp1);
	}
	
	/**
	 * Create an ArrayList of Characters that contains all combinations
	 * of the input operators with 1 - 5 values including repetitions.
	 */
	
	public void setOperator() {
		for (int h = 0; h < operators.length; h++) {
		if (h == 0)
			for (int i = 0; i < operators.length; i++) {
				for (int j = 0; j < operators.length; j++) {
					for (int k = 0; k < operators.length; k++) {
						for (int l = 0; l < operators.length; l++) {
							for (int m = 0; m < operators.length; m++) {
								ops = new ArrayList<Character>();
								if (i != 0)
									ops.add(operators[i]);
								if (j != 0)
									ops.add(operators[j]);
								if (k != 0)
									ops.add(operators[k]);
								if (l != 0)
									ops.add(operators[l]);
								if (m != 0)
									ops.add(operators[m]);
								if (!opPlace.contains(ops)&& ops.size() > 0) {
									opPlace.add(ops);
									}
								}
							}
						}
					}
				}
			}
	}
	
	/**
	 * Create a duplicate ArrayList of operators that can be manipulated later.
	 */
	
	public void setTempOperator(){			
		ArrayList<Character> tempALc;
		for(ArrayList<Character> t : opPlace){
			tempALc = new ArrayList<Character>();
			for(Character c : t ){	
					char cC = c;
					tempALc.add(cC);	
			}
			tempOpPlace.add(tempALc);
		}
	}
	
	/**
	 * reset the operators that were used in the last iteration of the
	 * operation to allow them to be manipulated in the next iteration
	 * @param x
	 */
	
	public void resetCurrentOperator(int y){
		ArrayList<Character> temp2;
		temp2 = new ArrayList<Character>();
		for (Character c: opPlace.get(y)){
			char c2 = c;
			temp2.add(c2);
		}
		tempOpPlace.set(y, temp2);
	}
	
	/**
	 * Create an ArrayList of Characters to represent the placing of brackets
	 * to be used when doing arithmetical operations on numbers based on all
	 * possible binary trees of length 1 - 5 operators.
	 * Values will be read in from a text file.
	 * @param filename
	 */
	
	public void setBinTree(String filename){
		try{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while(br.ready()){
				line = br.readLine();
				char [] b = line.toCharArray();
				tree = new ArrayList<Character>();
					for (int a = 0; a < b.length; a++){
					tree.add(b[a]);
				}
				binTree.add(tree);
			}
			br.close();
			for (int i = 0; i < binTree.size(); i++){
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Create a duplicate ArrayList of brackets that can be manipulated later.
	 */
	
	public void setTempBinTree(){
		
		ArrayList<Character> tempALc;
		for(ArrayList<Character> t : binTree){
			tempALc = new ArrayList<Character>();
			for(Character c : t ){
					char cC = c;
					tempALc.add(cC);	
			}
			tempBinTree.add(tempALc);
		}
	}
	
	/**
	 * reset the brackets that were used in the last iteration of the
	 * operation to allow them to be manipulated in the next iteration
	 * @param x
	 */
	
	public void resetCurrentBracket(int z){
		ArrayList<Character> temp3;
		temp3 = new ArrayList<Character>();
		for (Character c: binTree.get(z)){
			char c3 = c;
			temp3.add(c3);
		}
		tempBinTree.set(z, temp3);
	}
	
	/**
	 * For every selection of variables, operators and brackets that match in size
	 * send those sets to the checkBrackets method.
	 */
	
	public void setOperate(){
				for (int i = 0; i < varPlace.size(); i++) {
					for (int j = 0; j < opPlace.size(); j++) {
						for (int k = 0; k < binTree.size(); k++){
							if (opPlace.get(j).size() == varPlace.get(i).size() - 1 
								&& binTree.get(k).size() == 3 * opPlace.get(j).size()){
									checkBrackets(i,j,k,s);
							}
						}
					}
				}
			}
	
	/**
	 * For compatible sets, look through the temporary brackets set until two inward facing 
	 * brackets are found with a '*' (indicating an operator) in the middle.  Send these 
	 * values to the operate method.  Whenever a '*' is encountered until then, increment a 
	 * counter operatorPlace to keep track of the position that the operation is done.  
	 * If a set contains one Double, that value is stored in an array called solutions.
	 * @param numVariablesArray, numOperatorArray, numBracketArray, s
	 */
	
	public void checkBrackets(int numVariablesArray, int numOperatorArray, int numBracketArray, double s){
		int depth = 0;
		if (tempVarPlace.get(numVariablesArray).size() > 1){
			forloop:
			for (int m = 0; m < tempBinTree.get(numBracketArray).size(); m++){
				if (tempBinTree.get(numBracketArray).get(m) == '*'){
					operatorPlace++;
				}
				if (tempBinTree.get(numBracketArray).get(m) == '(' 
					&& tempBinTree.get(numBracketArray).get(m+2) == ')'){
					tempBinTree.get(numBracketArray).remove(m+2);
					tempBinTree.get(numBracketArray).remove(m+1);
					tempBinTree.get(numBracketArray).remove(m);
					depth++;
					operate(numVariablesArray,numOperatorArray,numBracketArray,operatorPlace);
					break forloop;
					}
				}
			}
		if (depth == 0){
		solutions.add(s);
		checkSolution(numVariablesArray,numOperatorArray,numBracketArray, s);
		resetCurrentVariable(numVariablesArray);
		resetCurrentOperator(numOperatorArray);
		resetCurrentBracket(numBracketArray);
		}
		depth--;
	}
	
	/**
	 * Takes the values at which to operate, does the applicable operation
	 * then removes from all the temp arrays the values used. This creates a 
	 * set of smaller arrays, and passes these back to the checkBrackets method.
	 * @param numVariablesArray, numOperatorArray, numBracketArray, currentOperatorIndex
	 */
	
	public void operate(int numVariablesArray, int numOperatorArray, int numBracketArray, int currentOperatorIndex){
			s = (double)tempVarPlace.get(numVariablesArray).get(currentOperatorIndex);
			if (tempOpPlace.get(numOperatorArray).get(currentOperatorIndex).equals('+')) {
				s += (double)tempVarPlace.get(numVariablesArray).get(currentOperatorIndex+1);
			}
			if (tempOpPlace.get(numOperatorArray).get(currentOperatorIndex).equals('-')) {
				s -= (double)tempVarPlace.get(numVariablesArray).get(currentOperatorIndex+1);
			}
			if (tempOpPlace.get(numOperatorArray).get(currentOperatorIndex).equals('x')) {
				s *= (double)tempVarPlace.get(numVariablesArray).get(currentOperatorIndex+1);
			}
			if (tempOpPlace.get(numOperatorArray).get(currentOperatorIndex).equals('/')) {
				s /= (double)tempVarPlace.get(numVariablesArray).get(currentOperatorIndex+1);
			}
			tempVarPlace.get(numVariablesArray).set(currentOperatorIndex, s);
			tempVarPlace.get(numVariablesArray).remove(currentOperatorIndex+1);
			tempOpPlace.get(numOperatorArray).remove(currentOperatorIndex);
			currentOperatorIndex = 0;
			operatorPlace = 0;
			checkBrackets(numVariablesArray,numOperatorArray,numBracketArray, s);
		}

	/**
	 * When a value is stored in the solution array, check to see if it matches the desired target.
	 * If it does, send the parameters (the indices of the applicable arrays of Characters and Doubles)
	 * to the printSolution method.
	 * @param x, y, z
	 */
	
	public void checkSolution(int x, int y, int z, double s){
			if (target == solutions.get(solutions.size()-1)){
				printSolution(x,y,z);
			}
	}
	
	/**
	 * Prints out the correct solution with the appropriate placing of brackets
	 * using the three indices from the checkSolution method.
	 * @param x, y, z
	 */
	
	public void printSolution(int x, int y, int z){
		int c = 0;
		int d = 0;
		StringBuffer b = new StringBuffer();
		b.append(target + " = ");
		for(int i = 0; i < binTree.get(z).size()-1; i++){
			if (binTree.get(z).get(i) == '(' && binTree.get(z).get(i+1) == '('){
				b.append(binTree.get(z).get(i));
			}
			else if (binTree.get(z).get(i) == '(' && binTree.get(z).get(i+1) == '*'){
				b.append(binTree.get(z).get(i));
				b.append(varPlace.get(x).get(c).intValue());
				c++;
			}
			else if (binTree.get(z).get(i) == '*' && binTree.get(z).get(i+1) == '('){
				b.append(opPlace.get(y).get(d));
				d++;
			}
			else if (binTree.get(z).get(i) == '*' && binTree.get(z).get(i+1) == ')'){
				b.append(opPlace.get(y).get(d));
				b.append(varPlace.get(x).get(c).intValue());
				c++;
				d++;
			}
			else if (binTree.get(z).get(i) == ')' && binTree.get(z).get(i+1) == '*'){
				b.append(binTree.get(z).get(i));
			}
			else if (binTree.get(z).get(i) == ')' && binTree.get(z).get(i+1) == ')'){
				b.append(binTree.get(z).get(i));
			}
		}
		b.append(')');
		answer = b.toString();
		System.out.println(answer);
		answers.add(answer);
		}	
	
	public static void main (String [] args){
		NewMethodTrees trial = new NewMethodTrees();
		trial.setVariable();
		trial.setTempVariable();
		trial.setOperator();
		trial.setTempOperator();
		trial.setBinTree("NewMethodTrees.txt");
		trial.setTempBinTree();
		trial.setOperate();
	}
	
}
