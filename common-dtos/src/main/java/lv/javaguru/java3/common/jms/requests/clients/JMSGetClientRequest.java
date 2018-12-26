package lv.javaguru.java3.common.jms.requests.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3.common.jms.SupportedCommandId;
import lv.javaguru.java3.common.jms.requests.JMSAPIRequest;

public class JMSGetClientRequest implements JMSAPIRequest {

    @JsonProperty("client_id")
    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getCommandId() {
        return SupportedCommandId.GET_CLIENT;
    }
}
