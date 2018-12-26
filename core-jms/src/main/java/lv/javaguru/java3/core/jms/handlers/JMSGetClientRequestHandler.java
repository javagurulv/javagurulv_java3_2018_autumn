package lv.javaguru.java3.core.jms.handlers;

import lv.javaguru.java3.common.jms.JMSRequest;
import lv.javaguru.java3.common.jms.SupportedCommandId;
import lv.javaguru.java3.common.jms.requests.clients.JMSGetClientRequest;
import lv.javaguru.java3.common.jms.requests.clients.JMSGetClientResponse;
import lv.javaguru.java3.core.api.commands.clients.GetClientCommand;
import lv.javaguru.java3.core.api.commands.clients.GetClientResult;
import lv.javaguru.java3.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSGetClientRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_CLIENT;
    }

    @Override
    public String process(JMSRequest request) {
        JMSGetClientRequest jmsCommand = mapRequest(request, JMSGetClientRequest.class);

        GetClientCommand coreCommand = new GetClientCommand(jmsCommand.getClientId());
        GetClientResult coreResult = executeCoreCommand(coreCommand);

        JMSGetClientResponse jmsResponse = new JMSGetClientResponse();
        jmsResponse.setClient(coreResult.getClient());
        return buildPayload(jmsResponse);
    }

}
