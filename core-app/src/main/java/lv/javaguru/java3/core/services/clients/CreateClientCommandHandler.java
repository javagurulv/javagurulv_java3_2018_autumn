package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.api.commands.clients.CreateClientCommand;
import lv.javaguru.java3.core.api.commands.clients.CreateClientResult;
import lv.javaguru.java3.common.dtos.ClientDTO;
import lv.javaguru.java3.core.domain.Client;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateClientCommandHandler
		implements DomainCommandHandler<CreateClientCommand, CreateClientResult> {

	@Autowired private ClientFactory clientFactory;
	@Autowired private ClientConverter clientConverter;


	@Override
	public CreateClientResult execute(CreateClientCommand command) {
		Client client = clientFactory.create(
				command.getLogin(),
				command.getPassword()
		);
		ClientDTO clientDTO = clientConverter.convert(client);
		return new CreateClientResult(clientDTO);
	}

	@Override
	public Class getCommandType() {
		return CreateClientCommand.class;
	}
	
}
