package se.lexicon.exception;

public class MYSQLConnectionException extends Exception{
    private String msg;

    public MYSQLConnectionException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
