package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.api.commands.clients.GetClientCommand;
import lv.javaguru.java3.api.commands.clients.GetClientResult;
import lv.javaguru.java3.api.dtos.ClientDTO;
import lv.javaguru.java3.core.domain.Client;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GetClientCommandHandler
        implements DomainCommandHandler<GetClientCommand, GetClientResult> {

    @Autowired private ClientService clientService;
    @Autowired private ClientConverter clientConverter;


    @Override
    public GetClientResult execute(GetClientCommand command) {
        Client client = clientService.get(command.getClientId());
        ClientDTO clientDTO = clientConverter.convert(client);
        return new GetClientResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return GetClientCommand.class;
    }

}