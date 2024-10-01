package library.management.system;

import java.util.HashMap;
import java.util.Map;

class BookRepository implements IRepository<Book> {
    private final Map<String, Book> books = new HashMap<>();

    @Override
    public void add(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public Book get(String id) {
        return books.get(id);
    }

    @Override
    public void remove(String id) {
        books.remove(id);
    }
}

class MemberRepository implements IRepository<Member> {
    private final Map<String, Member> members = new HashMap<>();

    @Override
    public void add(Member member) {
        members.put(member.getId(), member);
    }

    @Override
    public Member get(String id) {
        return members.get(id);
    }

    @Override
    public void remove(String id) {
        members.remove(id);
    }
}
