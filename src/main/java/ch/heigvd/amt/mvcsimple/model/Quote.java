package ch.heigvd.amt.mvcsimple.model;

public class Quote {

    private String author;
    private String citation;

    public Quote(String author, String citation) {
        this.author = author;
        this.citation = citation;
    }

    public String getAuthor() {
        return author;
    }

    public String getCitation() {
        return citation;
    }

}
