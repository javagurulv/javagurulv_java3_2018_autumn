package lv.javaguru.java3.common.jms.requests.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3.common.dtos.ClientDTO;

public class JMSRegisterClientResponse {

    @JsonProperty("client")
    private ClientDTO client;


    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
