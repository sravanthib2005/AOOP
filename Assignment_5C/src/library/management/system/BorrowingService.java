package library.management.system;

class BorrowingService {
    private final IRepository<Book> bookRepository;
    private final IRepository<Member> memberRepository;

    public BorrowingService(IRepository<Book> bookRepository, IRepository<Member> memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public void borrowBook(String bookId, String memberId) {
        Book book = bookRepository.get(bookId);
        Member member = memberRepository.get(memberId);

        if (book != null && member != null && book.isAvailable()) {
            book.borrowBook();
            System.out.println("Book " + book.getTitle() + " borrowed by " + member.getName());
        } else {
            System.out.println("Book not available or Member not found.");
        }
    }

    public void returnBook(String bookId) {
        Book book = bookRepository.get(bookId);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            System.out.println("Book " + book.getTitle() + " has been returned.");
        } else {
            System.out.println("Invalid return attempt.");
        }
    }
}
