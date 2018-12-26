package lv.javaguru.java3.app.jms.responsehandlers;

import lv.javaguru.java3.app.common.JsonMapper;
import lv.javaguru.java3.app.jms.JMSResponseHandler;
import lv.javaguru.java3.common.jms.JMSResponse;
import lv.javaguru.java3.common.jms.SupportedCommandId;
import lv.javaguru.java3.common.jms.requests.clients.JMSRegisterClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class JMSRegisterUserResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.REGISTER_CLIENT;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSRegisterClientResponse response = jsonMapper.mapToObject(
                payload, JMSRegisterClientResponse.class
        );
        return ResponseEntity.ok(response.getClient());
    }

}
