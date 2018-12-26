package lv.javaguru.java3.core.jms.handlers;

import lv.javaguru.java3.common.jms.JMSRequest;
import lv.javaguru.java3.common.jms.SupportedCommandId;
import lv.javaguru.java3.common.jms.requests.clients.JMSRegisterClientRequest;
import lv.javaguru.java3.common.jms.requests.clients.JMSRegisterClientResponse;
import lv.javaguru.java3.core.api.commands.clients.RegisterClientCommand;
import lv.javaguru.java3.core.api.commands.clients.RegisterClientResult;
import lv.javaguru.java3.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSRegisterUserRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.REGISTER_CLIENT;
    }

    @Override
    public String process(JMSRequest request) {
        JMSRegisterClientRequest jmsCommand = mapRequest(request, JMSRegisterClientRequest.class);

        RegisterClientCommand coreCommand = new RegisterClientCommand(
                jmsCommand.getClient().getLogin(),
                jmsCommand.getClient().getPassword()
        );
        RegisterClientResult coreResult = executeCoreCommand(coreCommand);

        JMSRegisterClientResponse jmsResponse = new JMSRegisterClientResponse();
        jmsResponse.setClient(coreResult.getClient());
        return buildPayload(jmsResponse);
    }

}
