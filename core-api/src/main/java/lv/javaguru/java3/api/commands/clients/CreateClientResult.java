package lv.javaguru.java3.api.commands.clients;

import lv.javaguru.java3.api.commands.DomainCommandResult;
import lv.javaguru.java3.api.dtos.ClientDTO;

public class CreateClientResult implements DomainCommandResult {

	private ClientDTO client;

	public CreateClientResult(ClientDTO client) {
		this.client = client;
	}

	public ClientDTO getClient() {
		return client;
	}

}
