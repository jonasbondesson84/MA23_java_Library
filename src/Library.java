import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
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
        System.out.println("Search for title:");
        searchTerm = sc.nextLine();
        for(Book book: books) {
            if(book.getTitle().equalsIgnoreCase(searchTerm)) {
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
                case "1", "yes" -> {
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
}
