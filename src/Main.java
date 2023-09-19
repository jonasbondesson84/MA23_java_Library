
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice = "";
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("", "", 0, 0);

        do {
            System.out.println("1. Add book to the library");
            System.out.println("2. Search for a book by name");
            System.out.println("3. List all available books");
            System.out.println("4. Reserv a book");
            System.out.println("5. Return a book");
            System.out.println("6. Quit");
            choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    book.addBook(books);
                    for (Book currentBook : books) {
                        System.out.println(currentBook);
                    }
                    break;
                }
                case "2" -> {
                    System.out.println(book.searchForBook(books));


                    break;
                }
                case "3" -> {
                    for (Book currentBook : books) {
                        if (currentBook.isAvailable()) {
                            System.out.println(currentBook);
                        }
                    }
                    break;
                }
                case "4" -> {
                    book.reservBook(book.searchForBook(books));
                    break;
                }

                case "5" -> {
                    book.returnBook(book.searchForBook(books));
                    break;
                }
            }

        } while (!choice.equalsIgnoreCase("6"));
        System.out.println("Thank you for using our library.");
    }
}