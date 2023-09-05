package br.com.cooperativeapi.exception;

public class AssociatedApiException extends RuntimeException {
    public AssociatedApiException(String msg, Exception ex) {
        super(msg, ex);
    }
}
