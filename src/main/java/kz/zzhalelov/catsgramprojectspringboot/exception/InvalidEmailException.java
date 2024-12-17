package kz.zzhalelov.catsgramprojectspringboot.exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
}