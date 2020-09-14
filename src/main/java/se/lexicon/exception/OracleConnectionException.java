package se.lexicon.exception;

public class OracleConnectionException extends Exception{
    private String msg;

    public OracleConnectionException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
