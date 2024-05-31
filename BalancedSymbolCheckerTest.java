/*
 * @author Sarthak Goyal
 */
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.jupiter.api.Test;

class BalancedSymbolCheckerTest {

	BalancedSymbolChecker b1 = new BalancedSymbolChecker();
	
	@Test
	void class1() throws FileNotFoundException {
		assertEquals("ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.", BalancedSymbolChecker.checkFile("./Assignments/examples/Class1.java"));
	}

	@Test
	void class2() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class2.java"), "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.");
	}

	@Test
	void class3() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class3.java"),  "No errors found. All symbols match.");
	}

	@Test
	void class4() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class4.java"), "ERROR: File ended before closing comment.");
	}

	@Test
	void class5() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class5.java"), "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.");
	}

	@Test
	void class6() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class6.java"), "No errors found. All symbols match.");
	}

	@Test
	void class7() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class7.java"), "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.");
	}

	@Test
	void class8() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class8.java"), "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.");
	}

	@Test
	void class9() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class9.java"), "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.");
	}

	@Test
	void class10() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class10.java"), "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.");
	}

	@Test
	void class11() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class11.java"), "ERROR: Unmatched symbol at the end of file. Expected }.");
	}

	@Test
	void class12() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class12.java"), "No errors found. All symbols match.");
	}
	
	@Test
	void class13() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class13.java"), "No errors found. All symbols match.");
	}

	@Test
	void class14() throws FileNotFoundException {
		assertEquals(BalancedSymbolChecker.checkFile("src/assign06/Class14.java"), "No errors found. All symbols match.");
	}


}
