package online.library.book.util;

import online.library.utility.model.Book;

import java.math.BigDecimal;
import java.util.Date;

public class BookTestUtil {
    public static final Book.BookBuilder bookLittlePrinceBuilder = Book.builder().title("Küçük Prens").releaseDate(new Date(0)).publisher("Antoine de Saint-Exupéry").price(BigDecimal.TEN).category("Çocuk Kitabı");
    public static final Book.BookBuilder bookFahrenheit451Builder = Book.builder().title("Fahrenheit 451").releaseDate(new Date(100)).publisher("Ray Bradbury").price(BigDecimal.TEN).category("Distopya");

    public static final Book bookLittlePrince = new Book(null, null, "Küçük Prens", new Date(0), "Antoine de Saint-Exupéry", BigDecimal.TEN, "Çocuk Kitabı");
    public static final Book bookFahrenheit451 = new Book(null, null, "Fahrenheit 451", new Date(100), "Ray Bradbury", BigDecimal.TEN, "Distopya");
}
