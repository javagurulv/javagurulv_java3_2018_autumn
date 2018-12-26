package lv.javaguru.java3.core.jms;

import lv.javaguru.java3.common.ResponseStatus;
import lv.javaguru.java3.common.errors.InternalServerError;
import lv.javaguru.java3.common.errors.ValidationException;
import lv.javaguru.java3.common.jms.JMSRequest;
import lv.javaguru.java3.common.jms.JMSResponse;
import lv.javaguru.java3.core.commons.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface JMSResponseBuilder {
    JMSResponse buildSuccess(JMSRequest request, String payload);
    JMSResponse buildFail(JMSRequest request, ValidationException e);
    JMSResponse buildFail(JMSRequest request, InternalServerError e);
    JMSResponse buildFail(JMSRequest request, RuntimeException e);
}

@Component
class JMSResponseBuilderImpl implements JMSResponseBuilder {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public JMSResponse buildSuccess(JMSRequest request,
                                    String payload) {
        return build(request, ResponseStatus.SUCCESS, payload);
    }

    @Override
    public JMSResponse buildFail(JMSRequest request, ValidationException e) {
        String payload = jsonMapper.mapToString(e.getValidationErrors());
        return build(request, e.getResultStatus(), payload);
    }

    @Override
    public JMSResponse buildFail(JMSRequest request, InternalServerError e) {
        return build(request, e.getResultStatus(), null);
    }

    @Override
    public JMSResponse buildFail(JMSRequest request, RuntimeException e) {
        return build(request, ResponseStatus.INTERNAL_SERVER_ERROR, null);
    }

    private JMSResponse build(JMSRequest request,
                              ResponseStatus responseStatus,
                              String payload) {
        JMSResponse response = new JMSResponse();
        response.setCommandId(request.getCommandId());
        response.setCorrelationId(request.getCorrelationId());
        response.setResponseStatus(responseStatus);
        response.setPayload(payload);
        return response;
    }

}
