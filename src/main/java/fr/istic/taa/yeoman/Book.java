package fr.istic.taa.yeoman;

public class Book {

    private Integer isbn;
    private String title;
    private String author;
    private int note;
    public Book() {
    }

    public Book(Integer isbn, String title, String author, int note) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.setNote(note);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
}
