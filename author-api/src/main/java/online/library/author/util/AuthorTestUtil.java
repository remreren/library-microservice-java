package online.library.author.util;

import online.library.utility.model.Author;

import java.util.Date;

public class AuthorTestUtil {
    public static final Date birthDateEmre = new Date();
    public static final Date birthDateVeli = new Date();

    public static final Author authorEmre = new Author(1L, "Emre", "Eren", birthDateEmre, null, "Balikesir", null, 1);
    public static final Author authorVeli = new Author(2L, "Ali", "Veli", birthDateVeli, null, "İstanbul", null, 1);
}
