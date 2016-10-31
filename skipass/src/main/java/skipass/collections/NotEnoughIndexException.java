package ua.yandex.skipass.collections;

public class NotEnoughIndexException extends RuntimeException {

    NotEnoughIndexException() {
    }

    NotEnoughIndexException(String args) {
        super(args);
    }
}
