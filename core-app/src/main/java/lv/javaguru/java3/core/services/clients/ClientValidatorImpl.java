package lv.javaguru.java3.core.services.clients;

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
            throw new IllegalArgumentException("Client login must not be null");
        }
        if (StringUtils.isEmpty(login)) {
            throw new IllegalArgumentException("Client login must not be empty");
        }
    }

    private void validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Client password must not be null");
        }
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Client password must not be empty");
        }
    }

}
