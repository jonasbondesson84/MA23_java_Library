import java.util.ArrayList;
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

    public void addBook(ArrayList<Book> books) {
        String title;
        String author;
        int year;
        int edition;
        System.out.println("title?");
        title = sc.nextLine();
        System.out.println("author?");
        author = sc.nextLine();
        System.out.println("Year?");
        year = sc.nextInt();
        sc.nextLine();
        System.out.println("Edition?");
        edition = sc.nextInt();
        sc.nextLine();

        books.add(new Book(title, author, year, edition));
    }

    public Book searchForBook(ArrayList<Book> books) {
        String searchTerm;
        ArrayList<String> titleBooks = new ArrayList<>();
        System.out.println("Search for title:");
        searchTerm = sc.nextLine();
        for(Book book: books) {
            if(book.title.equalsIgnoreCase(searchTerm)) {
                return book;
            }
        }
        return null;
    }

    public void reservBook(Book book) {
        String answer;
        if(book != null && book.isAvailable()) {
            System.out.println("Do you want to make a reservation for " + book.getTitle() + " by author " + book.getAuthor() + "?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            answer = sc.nextLine();
            switch (answer.toLowerCase()) {
                case "1", "yes " -> {
                    book.setAvailable(false);
                    System.out.println("Book reserved! \n");
                }
                case "2", "no" -> {
                    System.out.println("Okay! \n");
                }
            }
        } else {
            System.out.println("Book does not exist or is already reserved. \n");
        }
    }

    public void returnBook(Book book) {
        String answer;
        if(book != null && !book.isAvailable()) {
            System.out.println("Do you want to return " + book.getTitle() + " by author " + book.getAuthor() + "?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            answer = sc.nextLine();
            switch (answer.toLowerCase()) {
                case "1", "yes" -> {
                    book.setAvailable(true);
                    System.out.println("Book returned! \n");
                }
                case "2", "no" -> {
                    System.out.println("Okay! /n");
                }
            }
        } else {
            System.out.println("Book does not exist or is not reserved. \n");
        }
    }


    public String toString() {
        return "Title: " + title + " - by " + author + ". Year " + year + ", edition " + edition + ". This book is " + (available ? "available" : "reserved");
    }
}
