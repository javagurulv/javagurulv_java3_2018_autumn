package lv.javaguru.java3.api.commands.clients;

import lv.javaguru.java3.api.commands.DomainCommand;

public class CreateClientCommand implements DomainCommand<CreateClientResult> {

    private String login;
    private String password;


    public CreateClientCommand(String login,
                               String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
