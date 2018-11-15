package lv.javaguru.java3.api.commands.clients;

import lv.javaguru.java3.api.commands.DomainCommandResult;
import lv.javaguru.java3.api.dtos.ClientDTO;

public class GetClientResult implements DomainCommandResult {

    private ClientDTO client;

    public GetClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}
