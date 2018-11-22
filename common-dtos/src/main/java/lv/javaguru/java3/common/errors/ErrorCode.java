package lv.javaguru.java3.common.errors;

public enum ErrorCode {

    VALIDATION_INVALID_FIELD_VALUE(Category.VALIDATION, Code.INVALID_FIELD_VALUE, 400),
    VALIDATION_MISSING_FIELD(Category.VALIDATION, Code.MISSING_FIELD, 400);

    private Category category;
    private Code code;
    private int httpCode;

    ErrorCode(Category category, Code code, int httpCode) {
        this.category = category;
        this.code = code;
        this.httpCode = httpCode;
    }

    public enum Category {
        VALIDATION,
        INTERNAL
    }

    public enum Code {
        INVALID_FIELD_VALUE,
        MISSING_FIELD
    }

}
