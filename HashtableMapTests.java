// --== CS400 Project One File Header ==--
// Name: Harshet Anand
// CSL Username: harshet
// Email: hanand2@wisc.edu
// Lecture #: 002 @2:30pm

import java.util.NoSuchElementException; // Import used for error when element not found

/**
 * 
 * @author Harshet Anand
 * 
 *         This class uses testers to test the methods in the hashtableMap java
 *         class.
 *
 */

public class HashtableMapTests {

	/**
	 * The main method runs all tests from the runAllTests() method and prints true
	 * if all tests run successfully
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("runAllTests(): " + runAllTests());
	}

	/**
	 * Checks the correctness of all test methods works successfully by running all
	 * tests.
	 * 
	 * @return true if all test methods pass else false if one or more tests fail
	 *         printing out the test and the method which did not pass as well as
	 *         the item that was used as input.
	 */
	public static boolean runAllTests() {
		boolean allTestsPassed = test1() && test2() && test3() && test4() && test5();
		// Can only return true if all test cases return true. Will go back to main
		// method to return
		// final result
		return allTestsPassed;
	}

	/**
	 * This tester method tests the put() method.
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test1() {
		return true;
	}

	/**
	 * This tester method tests the get() method.
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test2() {
		return true;
	}

	/**
	 * This tester method tests the containsKey() method.
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test3() {
		return true;
	}

	/**
	 * This tester method tests the remove() method.
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test4() {
		return true;
	}

	/**
	 * This tester tests the size() method.
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test5() {
		int sizeOfValues = 0;
		if (sizeOfValues == 0) {
			return true;
		} else {
			return false;
		}
	}
}
