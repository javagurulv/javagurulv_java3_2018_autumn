package lv.javaguru.java3.app.jms.responsehandlers;

import lv.javaguru.java3.app.common.JsonMapper;
import lv.javaguru.java3.app.jms.JMSResponseHandler;
import lv.javaguru.java3.common.jms.JMSResponse;
import lv.javaguru.java3.common.jms.SupportedCommandId;
import lv.javaguru.java3.common.jms.requests.clients.JMSGetClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class JMSGetUserResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.GET_CLIENT;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSGetClientResponse response = jsonMapper.mapToObject(
                payload, JMSGetClientResponse.class
        );
        return ResponseEntity.ok(response.getClient());
    }

}
