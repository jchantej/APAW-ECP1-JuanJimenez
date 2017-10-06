package Patrones.Builder;

import Patrones.Author;

public class AuthorBuilder {
    private Author author;

    public AuthorBuilder() {
        this.author = new Author();
    }

    public AuthorBuilder id(long id) {
        this.author.setId(id);
        return this;
    }

    public AuthorBuilder name(String name) {
        this.author.setName(name);
        return this;
    }

    public AuthorBuilder language(String language) {
        this.author.setLanguage(language);
        return this;
    }

    public Author build() {
        return this.author;
    }

}
