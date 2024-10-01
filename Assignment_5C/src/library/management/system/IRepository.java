package library.management.system;

interface IRepository<T> {
    void add(T item);
    T get(String id);
    void remove(String id);
}
