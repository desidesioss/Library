import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void borrowBook(String title) throws BookUnavailableException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book borrowed: " + title);
                return;
            }
        }
        throw new BookUnavailableException("Book not available: " + title);
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("Book returned: " + book.getTitle());
    }

    public List<Book> searchByGenre(Genre genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if ((genre == Genre.FICTION && book instanceof FictionBook) ||
                (genre == Genre.NON_FICTION && book instanceof NonFictionBook)) {
                result.add(book);
            }
        }
        return result;
    }

    public static class LibraryHelper {
        public static Book searchByTitle(List<Book> books, String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }
    }
}
