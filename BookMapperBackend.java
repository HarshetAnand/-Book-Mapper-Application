import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BookMapperBackend implements IBookMapperBackend {

	AlgoEngPlaceholder book = new AlgoEngPlaceholder(1);
	int sizeOfBooks = 0;
	String authorFilter = null;
	private AlgoEngPlaceholder map;

	@Override
	public void addBook(IBook book) {
		book.put(book.getISBN13(), book);
		sizeOfBooks = sizeOfBooks + 1;

	}

	@Override
	public int getNumberOfBooks() {
		return this.sizeOfBooks;
	}

	@Override
	public void setAuthorFilter(String filterBy) {
		this.authorFilter = filterBy;
	}

	@Override
	public String getAuthorFilter() {
		return this.authorFilter;
	}

	@Override
	public void resetAuthorFilter() {
		this.authorFilter = null;
	}

	@Override
	public List<IBook> searchByTitleWord(String word) {
		List<IBook> bookTitleList = new ArrayList<>();

		while (map.iterator().hasNext()) {
			IBook bookName = (IBook) map.iterator().next();
			String titleOfTheBook = bookName.getTitle();

			if (titleOfTheBook.toLowerCase().contains(word.toLowerCase()) && bookName.getAuthors() == null) {
				bookTitleList.add((IBook) map.iterator().next());
			}

			else if (titleOfTheBook.toLowerCase().contains(word.toLowerCase()) && bookName.getAuthors() != null) {
				bookTitleList.add((IBook) map.iterator().next());
			}
		}

		return bookTitleList;

	}

	@Override
	public IBook getByISBN(String ISBN) {
		IBook res = null;
		List<IBook> books;

		try {
			books = (new BookLoader()).loadBooks("books.CSV");
			for (IBook book : books) {
				if (book.getISBN13().equals(ISBN)) {
					res = book;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error! ISBN not found!");
		}
		return res;
	}
}
