/*
 * @author Sarthak Goyal
 * @version February 28, 2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Erin Parker && Vignesh Iyer and Sarthak Goyal
 * @version February 23, 2019
 */
public class BalancedSymbolChecker  {

	static LinkedListStack<Character> stack = new LinkedListStack<Character>();
	
	private static int LineNumber = 0;

	/**
	 * Generates a message indicating whether the input file has unmatched
	 * symbols. (Use the helper methods below for constructing messages.)
	 * 
	 * @param filename - name of the input file to check
	 * @return a message indicating whether the input file has unmatched symbols
	 * @throws FileNotFoundException if the file does not exist
	 */
	public static String checkFile(String filename) throws FileNotFoundException {
		//File f1 = new File(filename);
		Scanner sc = new Scanner(new File(filename));
		while(sc.hasNext()) {
			String a = sc.nextLine();
			char[] ch = new char[100]; 
			ch = a.toCharArray();
			LineNumber = LineNumber + 1;
			
			for(int i = 0; i < ch.length; i++) {
				
				if(ch[i] == '/' && ch[i + 1] == '*') {
					i = i + 2;
					while(ch[i] != '*' && ch[i + 1] != '/') {
						if(i == ch.length && (ch[i-1] != '*' && ch[i] != '/')) {
							unfinishedComment();
							
						}
					}
					Boolean commentMode = true;
						i++;
				}
				
				if(ch[i] == '{' || ch[i] == '(' || ch[i] == '[') {
					stack.push(ch[i]);
				}
				
				if(ch[i] == '}' && stack.peek() == '{') {
					stack.pop();
				}
				
				if(ch[i] == ')' && stack.peek() == '(') {
					stack.pop();
				}
				
				if(ch[i] == ']' && stack.peek() == '[') {
					stack.pop();
				}
				
				if(ch[i] == '}' && stack.peek() != '{') {
					unmatchedSymbol(LineNumber, i, '}', '{');
				}
				
				if(ch[i] == ')' && stack.peek() != '(') {
					unmatchedSymbol(LineNumber, i, ')', '(');
				}
				
				if(ch[i] == ']' && stack.peek() != '[') {
					unmatchedSymbol(LineNumber, i, ']', '[');
				}
				
				
				if(ch[i] == '/' && ch[i + 1] == '/') {
						sc.nextLine();
				}
				
				if(ch[i] == '\"') {
					i++;
					while(ch[i] != '\"')
						if(i == ch.length && ch[i] != '\"') 
							unmatchedSymbol(LineNumber, i, ch[i], '\"');
						i++;
				}
				
				if(ch[i] == '\'') {
					i++;
					while(ch[i] != '\'') { 
						if(i == ch.length && ch[i] != '\'') { 
							unmatchedSymbol(LineNumber, i, ch[i], '\'');
						}
						i++;
					}
				}		
			}
			
			if(!stack.isEmpty()) {
				unmatchedSymbolAtEOF(stack.peek());
			}
		}
		return allSymbolsMatch();
	}

	/**
	 * Use this error message in the case of an unmatched symbol.
	 * 
	 * @param lineNumber - the line number of the input file where the matching symbol was expected
	 * @param colNumber - the column number of the input file where the matching symbol was expected
	 * @param symbolRead - the symbol read that did not match
	 * @param symbolExpected - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
				+ ", but read " + symbolRead + " instead.";
	}

	/**
	 * Use this error message in the case of an unmatched symbol at the end of the file.
	 * 
	 * @param symbolExpected - the matching symbol expected
	 * @return the error message
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Use this error message in the case of an unfinished comment
	 * (i.e., a file that ends with an open /* comment).
	 * 
	 * @return the error message
	 */
	private static String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Use this message when no unmatched symbol errors are found in the entire file.
	 * 
	 * @return the success message
	 */
	private static String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}