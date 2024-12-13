class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public void read() {
        System.out.println("Reading a non-fiction book: " + getTitle());
    }
}
