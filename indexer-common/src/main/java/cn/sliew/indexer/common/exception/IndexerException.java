package cn.sliew.indexer.common.exception;

public class IndexerException extends RuntimeException {

    protected long code = IndexerExceptionEnum.FAILURE.getCode();

    public IndexerException() {
        super();
    }

    public IndexerException(String message) {
        super(message);
    }

    public IndexerException(Throwable cause) {
        super(cause);
    }

    public IndexerException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexerException(long code, String message) {
        super(message);
        this.code = code;
    }

    public IndexerException(IndexerExceptionEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    public long getCode() {
        return this.code;
    }
}
