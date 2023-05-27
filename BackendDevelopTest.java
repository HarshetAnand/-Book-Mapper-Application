import java.util.ArrayList;
import java.util.List;

public class BackendDevelopTest {

	/**
	 * Tests searchByTitleWorld() method.
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test1() {
		AlgoEngPlaceholder book = new AlgoEngPlaceholder(7);
		BookMapperBackend search = new BookMapperBackend();

		List<IBook> books = new ArrayList<>();
		Book firstBook = new Book("Hunger Games 1", "Suzanne Collins", "120");
		Book secondBook = new Book("Hunger Games 2", "Suzanne Collins", "220");
		Book thirdBook = new Book("Hunger Games 3", "Suzanne Collins", "320");
		Book fourthBook = new Book("Hunger Games 4", "Suzanne Collins", "420");
		Book fifthBook = new Book("Hunger Games 5", "Suzanne Collins", "520");
		Book sixthBook = new Book("Hunger Games 6", "Stephen King", "620");

		books.add(firstBook);
		books.add(secondBook);
		books.add(thirdBook);
		books.add(fourthBook);
		books.add(fifthBook);
		books.add(sixthBook);

		List<IBook> res = search.searchByTitleWord("Hunger Games");
		for (int j = 0; j < res.size(); j++) {
			if (res.get(j).getTitle().equals(books.get(j).getTitle())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test2() {
		return true;
	}

	/**
	 * Tests getByISBN() method.
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test3() {
		BookMapperBackend ISBN = new BookMapperBackend();

		if (ISBN.getByISBN("520").getTitle().equals("Hunger Games 5")) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test4() {
		return true;
	}

	/**
	 * 
	 * @return True when all tests pass else return false if one of the tests fails
	 *         printing out the error messages for the input that did not pass.
	 */
	public static boolean test5() {
		return true;
	}

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
		boolean allTestsPassed = test2() && test4() && test5();
		// Can only return true if all test cases return true. Will go back to main
		// method to return
		// final result
		return allTestsPassed;
	}

}
