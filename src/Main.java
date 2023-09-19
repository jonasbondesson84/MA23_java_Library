import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;
        Library library = new Library();

        do {
            System.out.println("1. Add book to the library");
            System.out.println("2. Search for a book by title");
            System.out.println("3. List all available books");
            System.out.println("4. Reserv a book");
            System.out.println("5. Return a book");
            System.out.println("6. Quit");
            choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    library.addBook(library.getBooks());
                    for (Book currentBook : library.getBooks()) {
                        System.out.println(currentBook);
                    }
                    System.out.println();
                }
                case "2" -> {
                    System.out.println(library.searchForBook(library.getBooks()) + "\n");
                }
                case "3" -> {
                    for (Book currentBook : library.getBooks()) {
                        if (currentBook.isAvailable()) {
                            System.out.println(currentBook);
                        }
                    }
                    System.out.println();
                }
                case "4" -> {
                    library.reservBook(library.searchForBook(library.getBooks()));
                }
                case "5" -> {
                    library.returnBook(library.searchForBook(library.getBooks()));
                }
            }

        } while (!choice.equalsIgnoreCase("6"));
        System.out.println("Thank you for using our library.");
    }
}