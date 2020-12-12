package cn.sliew.indexer.common.exception;

public enum IndexerExceptionEnum {

    SUCCESS(0L, "success"),
    FAILURE(1L, "failure"),

    SYS_EXCEPTION(100L, "server exception"),
    UNKNOWN_EXCEPTION(101L, "unknown exception"),
    UNDEFINED_EXCEPTION(102L, "undefined exception"),
    LIMITED_EXCEPTION(103L, "limited exception"),
    FUSED_EXCEPTION(104L, "fused exception"),
    DEMOTED_EXCEPTION(105L, "demoted exception"),

    BLANK_PARAM_EXCEPTION(200L, "blank param"),
    INVALID_PARAM_EXCEPTION(201L, "invalid param"),

    EXIST_DATA_EXCEPTION(300L, "data already exists"),
    INVALID_DATA_EXCEPTION(301L, "data invalid"),
    NOT_FOUND_DATA_EXCEPTION(302L, "data not found"),
    INVALID_FORMAT_DATA_EXCEPTION(304L, "data invalid format"),

    RPC_INVOKE_EXCEPTION(400L, "rpc invoke error"),
    HTTP_INVOKE_EXCEPTION(401L, "http invoke error"),

    ;
    private long code;
    private String message;

    IndexerExceptionEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
