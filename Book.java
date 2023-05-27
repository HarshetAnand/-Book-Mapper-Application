public class Book implements IBook {
	private String author;
	private String ISBN;
	private String title;

	public Book(String author, String ISBN, String title) {
		this.author = author;
		this.ISBN = ISBN;
		this.title = title;
	}

	@Override
	public String getAuthors() {
		return this.author;
	}

	@Override
	public String getISBN13() {
		return this.ISBN;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void put(String isbn13, IBook book) {
		// TODO Auto-generated method stub

	}
}
