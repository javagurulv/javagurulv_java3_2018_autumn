package lv.javaguru.java3.core.services.clients;

import lv.javaguru.java3.core.domain.Client;
import lv.javaguru.java3.api.dtos.ClientDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.api.dtos.ClientDTOBuilder.createClientDTO;

@Component
class ClientConverter {

    public ClientDTO convert(Client client) {
        return createClientDTO()
                .withId(client.getId())
                .withLogin(client.getLogin())
                .withPassword(client.getPassword()).build();
    }


}
