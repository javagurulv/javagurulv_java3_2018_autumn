package lv.javaguru.java3.core.services;

import lv.javaguru.java3.api.commands.DomainCommand;
import lv.javaguru.java3.api.commands.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}
