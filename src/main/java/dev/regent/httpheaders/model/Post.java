package dev.regent.httpheaders.model;

public record Post(Integer id, Integer userId, String title, String body) {
    @Override
    public String toString() {
        return "Post: { \n" +
                "\t id: " + id + ",\n" +
                "\t userId: " + userId + ",\n" +
                "\t title: " + title  + ",\n" +
                "\t body: " + body  + "\n" +
                '}';
    }
}
