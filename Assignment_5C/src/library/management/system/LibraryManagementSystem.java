package library.management.system;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // Create repositories
        BookRepository bookRepository = new BookRepository();
        MemberRepository memberRepository = new MemberRepository();

        // Add books and members
        bookRepository.add(new Book("1", "1984", "George Orwell"));
        bookRepository.add(new Book("2", "To Kill a Mockingbird", "Harper Lee"));
        memberRepository.add(new Member("1", "John Doe"));
        memberRepository.add(new Member("2", "Jane Smith"));

        // Create borrowing service
        BorrowingService borrowingService = new BorrowingService(bookRepository, memberRepository);

        // Borrowing books
        borrowingService.borrowBook("1", "1");  // John Doe borrows "1984"
        borrowingService.borrowBook("1", "2");  // Jane Smith tries to borrow "1984", but it's unavailable
        borrowingService.borrowBook("2", "2");  // Jane Smith borrows "To Kill a Mockingbird"

        // Returning books
        borrowingService.returnBook("1");       // John Doe returns "1984"
        borrowingService.borrowBook("1", "2");  // Jane Smith borrows "1984"
    }
}
