package ug.co.absa.notify.utility;

public enum Constants {

    VALIDATION_URL(0, "The operation was successful."),
    SEND_MESSAGE_URL(1, "The operation failed.");


    private final int id;
    private final String message;

    Constants(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() { return id; }
    public String getMessage() { return message; }
}









