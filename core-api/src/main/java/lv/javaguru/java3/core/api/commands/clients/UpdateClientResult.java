package lv.javaguru.java3.core.api.commands.clients;

import lv.javaguru.java3.core.api.commands.DomainCommandResult;
import lv.javaguru.java3.common.dtos.ClientDTO;

public class UpdateClientResult implements DomainCommandResult {

    private ClientDTO client;

    public UpdateClientResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }

}
