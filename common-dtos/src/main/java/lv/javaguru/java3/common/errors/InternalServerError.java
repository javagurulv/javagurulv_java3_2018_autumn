package lv.javaguru.java3.common.errors;

import lv.javaguru.java3.common.ResponseStatus;

public class InternalServerError extends ApplicationException {

    public InternalServerError() {
        super(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
