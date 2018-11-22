package lv.javaguru.java3.core.rest;

import lv.javaguru.java3.common.dtos.ClientDTO;
import lv.javaguru.java3.core.api.CommandExecutor;
import lv.javaguru.java3.core.api.commands.clients.CreateClientCommand;
import lv.javaguru.java3.core.api.commands.clients.CreateClientResult;
import lv.javaguru.java3.core.api.commands.clients.GetClientCommand;
import lv.javaguru.java3.core.api.commands.clients.GetClientResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class ClientRestController {

    private CommandExecutor commandExecutor;

    @Autowired
    public ClientRestController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @RequestMapping(method = RequestMethod.POST, value="/clients")
    @ResponseBody
    public ClientDTO create(ClientDTO clientDTO) {
        CreateClientCommand command = new CreateClientCommand(
                clientDTO.getLogin(), clientDTO.getPassword()
        );
        CreateClientResult result = commandExecutor.execute(command);
        return result.getClient();
    }

    @GetMapping("/clients/{clientId}")
    @ResponseBody
    public ClientDTO get(@PathVariable("clientId") Long clientId) {
        GetClientCommand command = new GetClientCommand(clientId);
        GetClientResult result = commandExecutor.execute(command);
        return result.getClient();
    }

}
