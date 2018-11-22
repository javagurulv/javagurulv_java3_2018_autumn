package lv.javaguru.java3.core.api.errors;

import lv.javaguru.java3.common.errors.ErrorCode;
import lv.javaguru.java3.common.errors.ErrorEmitter;

public class CoreValidationError extends RuntimeException {

    private ErrorCode errorCode;
    private String description;
    private ErrorEmitter errorEmitter;

    public CoreValidationError(ErrorCode errorCode,
                               String description,
                               ErrorEmitter errorEmitter) {
        this.errorCode = errorCode;
        this.description = description;
        this.errorEmitter = errorEmitter;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public ErrorEmitter getErrorEmitter() {
        return errorEmitter;
    }

}
