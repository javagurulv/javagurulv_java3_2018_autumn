package lv.javaguru.java3.core.api.commands.clients;

import lv.javaguru.java3.core.api.commands.DomainCommandResult;
import lv.javaguru.java3.common.dtos.ClientDTO;

public class RegisterClientResult implements DomainCommandResult {

	private ClientDTO client;

	public RegisterClientResult(ClientDTO client) {
		this.client = client;
	}

	public ClientDTO getClient() {
		return client;
	}

}
