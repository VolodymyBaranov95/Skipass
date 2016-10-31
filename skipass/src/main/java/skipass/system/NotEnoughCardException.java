package ua.yandex.skipass.system;

public class NotEnoughCardException extends RuntimeException {

    NotEnoughCardException() {
    }

    NotEnoughCardException(String args) {
        super(args);
    }
}
