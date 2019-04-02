package parser;

import java.util.StringJoiner;

public class Article {
    private String url;

    Article(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Article.class.getSimpleName() + "[", "]")
                .add("url='" + url + "'")
                .toString();
    }
}
