package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.api.commands.clients.RegisterClientCommand;
import lv.javaguru.java3.core.api.commands.clients.RegisterClientResult;
import lv.javaguru.java3.common.dtos.ClientDTO;
import lv.javaguru.java3.core.domain.Client;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RegisterClientCommandHandler
		implements DomainCommandHandler<RegisterClientCommand, RegisterClientResult> {

	@Autowired private ClientFactory clientFactory;
	@Autowired private ClientConverter clientConverter;


	@Override
	public RegisterClientResult execute(RegisterClientCommand command) {
		Client client = clientFactory.create(
				command.getLogin(),
				command.getPassword()
		);
		ClientDTO clientDTO = clientConverter.convert(client);
		return new RegisterClientResult(clientDTO);
	}

	@Override
	public Class getCommandType() {
		return RegisterClientCommand.class;
	}
	
}
