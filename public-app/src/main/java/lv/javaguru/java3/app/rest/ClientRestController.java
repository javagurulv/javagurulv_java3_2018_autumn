package lv.javaguru.java3.app.rest;

import lv.javaguru.java3.app.jms.JMSRequestProcessor;
import lv.javaguru.java3.common.dtos.ClientDTO;
import lv.javaguru.java3.common.jms.requests.clients.JMSGetClientRequest;
import lv.javaguru.java3.common.jms.requests.clients.JMSRegisterClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class ClientRestController {

    @Autowired private JMSRequestProcessor jmsRequestProcessor;


    @RequestMapping(method = RequestMethod.POST, value="/clients")
    @ResponseBody
    public DeferredResult<ResponseEntity> register(ClientDTO clientDTO) {
        JMSRegisterClientRequest jmsRequest = new JMSRegisterClientRequest();
        jmsRequest.setClient(clientDTO);
        return jmsRequestProcessor.process(jmsRequest);
    }

    @GetMapping("/clients/{clientId}")
    @ResponseBody
    public DeferredResult<ResponseEntity> get(@PathVariable("clientId") Long clientId) {
        JMSGetClientRequest jmsRequest = new JMSGetClientRequest();
        jmsRequest.setClientId(clientId);
        return jmsRequestProcessor.process(jmsRequest);
    }

}
