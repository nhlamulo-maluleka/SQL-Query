package Responses;

public class Response {
    public String message;

    public Response(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}