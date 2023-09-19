import java.util.Scanner;

public class Book {
    Scanner sc = new Scanner(System.in);
    private String title;
    private String author;
    private int year;
    private int edition;
    private boolean available;

    public Book(String title, String author, int year, int edition) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.edition = edition;
        this.available = true;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return "Title: " + title + " - by " + author + ". Year " + year + ", edition " + edition + ". This book is " + (available ? "available" : "reserved");
    }
}
