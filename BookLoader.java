import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BookLoader implements IBookLoader {

	public List<IBook> loadBooks(String filepathToCSV) throws FileNotFoundException {
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
		return books;
	}
}