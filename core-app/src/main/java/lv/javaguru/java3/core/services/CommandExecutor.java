package lv.javaguru.java3.core.services;

import lv.javaguru.java3.api.commands.DomainCommand;
import lv.javaguru.java3.api.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}
