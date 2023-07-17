package ug.co.absa.notify.utility;


   public enum Errors {

        SUCCESS(0, "The operation was successful."),
        FAILURE(1, "The operation failed."),
        ERROR(2, "An error has occured."),
        WARNING_NO_MAIL_FOUND(3, "The operation was successful but the no email found"),

       UNKNOWN_EXCEPTION_(11, "Something went wrong"),

/*
       WARNING_NO_MAIL_FOUND(3, "The operation was successful but the no email found"),
*/

       FAILED_TO_SEND_MAIL(5, "The operation was successful but the system is currently");



        private final int id;
        private final String message;

        Errors(int id, String message) {
            this.id = id;
            this.message = message;
        }

        public int getId() { return id; }
        public String getMessage() { return message; }
    }









