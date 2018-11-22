package lv.javaguru.java3.core.api.commands.clients;

import lv.javaguru.java3.core.api.commands.DomainCommandResult;
import lv.javaguru.java3.common.dtos.ClientDTO;

public class GetClientResult implements DomainCommandResult {

    private ClientDTO client;

    public GetClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}
