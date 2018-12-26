package lv.javaguru.java3.common.jms.requests.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3.common.dtos.ClientDTO;
import lv.javaguru.java3.common.jms.SupportedCommandId;
import lv.javaguru.java3.common.jms.requests.JMSAPIRequest;

public class JMSRegisterClientRequest implements JMSAPIRequest {

    @JsonProperty("client")
    private ClientDTO client;


    @Override
    public String getCommandId() {
        return SupportedCommandId.REGISTER_CLIENT;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
