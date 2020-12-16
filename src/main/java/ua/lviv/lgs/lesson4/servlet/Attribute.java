package ua.lviv.lgs.lesson4.servlet;

public enum Attribute {
    REQUEST_JOURNALS("journals"),
    SESSION_USER_KEY("user"),
    REQUEST_USER_NAME_KEY("userName"),
    REQUEST_LOGIN_ERROR("userLoginError"),
    REQUEST_REGISTRATION_ERROR("userRegistrationError"),
    REQUEST_CHOSEN_JOURNALS("chosenJournals");

    private final String value;

    Attribute(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
