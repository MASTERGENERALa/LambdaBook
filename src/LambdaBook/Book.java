package LambdaBook;

public class Book {
    private String title;
    private String author;
    private int yearPublished;

    // Конструктор класу Book
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    // Метод для отримання назви книги
    public String getTitle() {
        return title;
    }

    // Метод для отримання автора книги
    public String getAuthor() {
        return author;
    }

    // Метод для отримання року видання книги
    public int getYearPublished() {
        return yearPublished;
    }

    public static void main(String[] args) {
        // Замикання анонімного класу
        Book book1 = new Book("Book 1", "Author 1", 2021) {
            @Override
            public String getTitle() {
                return "Custom title: " + super.getTitle();
            }
        };

        System.out.println("Anonymous class:");
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
        System.out.println("Year Published: " + book1.getYearPublished());

        // Замикання лямбда-виразу
        Book book2 = new Book("Book 2", "Author 2", 2022);
        book2.setTitleProvider(() -> "Custom title: " + book2.getTitle());

        System.out.println("\nLambda expression:");
        System.out.println("Title: " + book2.getTitle());
        System.out.println("Author: " + book2.getAuthor());
        System.out.println("Year Published: " + book2.getYearPublished());
    }

    // Інтерфейс для лямбда-виразу
    interface TitleProvider {
        String getTitle();
    }

    // Поле для лямбда-виразу
    private TitleProvider titleProvider;

    // Метод для встановлення лямбда-виразу
    public void setTitleProvider(TitleProvider titleProvider) {
        this.titleProvider = titleProvider;
    }

    // Метод для отримання назви книги через лямбда-вираз
    public String getTitleUsingLambda() {
        if (titleProvider != null) {
            return titleProvider.getTitle();
        } else {
            return title;
        }
    }
}
