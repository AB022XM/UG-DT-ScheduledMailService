package ug.co.absa.notify.utility;


    enum ALERT_STATUS {

        SENT("3"),
        FAILURE("5"),
        NO_MAIL("6"),
        PENDING("2");

        private String value;

        private ALERT_STATUS(String value) {
            this.value = value;
        }


        public String getValue() {
            return value;
        }

        public static ALERT_STATUS fromValue(String value) {
            for (ALERT_STATUS c : ALERT_STATUS.values()) {
                if (c.value.equals(value)) {
                    return c;
                }
            }
            throw new        IllegalArgumentException("Unexpected value '" + value + "'");
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ALERT_STATUS fromString(String text) {
            for (ALERT_STATUS c : ALERT_STATUS.values()) {
                if (String.valueOf(c.value).equals(text)) {
                    return c;
                }
            }
            return null;
        }

        public static ALERT_STATUS fromInt(int value) {
            return fromValue(String.valueOf(value));

        }



    }



