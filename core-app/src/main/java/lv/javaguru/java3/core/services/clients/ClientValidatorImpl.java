package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.common.errors.ErrorCode;
import lv.javaguru.java3.common.errors.ErrorEmitter;
import lv.javaguru.java3.core.api.errors.CoreValidationError;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
class ClientValidatorImpl implements ClientValidator {

    @Override
    public void validate(String login, String password) {
        validateLogin(login);
        validatePassword(password);
    }

    private void validateLogin(String login) {
        if (login == null) {
            throw new CoreValidationError(
                    ErrorCode.VALIDATION_MISSING_FIELD,
                    "login",
                    ErrorEmitter.CORE_APP
            );
        }
        if (StringUtils.isEmpty(login)) {
            throw new CoreValidationError(
                    ErrorCode.VALIDATION_INVALID_FIELD_VALUE,
                    "login",
                    ErrorEmitter.CORE_APP
            );
        }
    }

    private void validatePassword(String password) {
        if (password == null) {
            throw new CoreValidationError(
                    ErrorCode.VALIDATION_MISSING_FIELD,
                    "password",
                    ErrorEmitter.CORE_APP
            );
        }
        if (StringUtils.isEmpty(password)) {
            throw new CoreValidationError(
                    ErrorCode.VALIDATION_INVALID_FIELD_VALUE,
                    "password",
                    ErrorEmitter.CORE_APP
            );
        }
    }

}
