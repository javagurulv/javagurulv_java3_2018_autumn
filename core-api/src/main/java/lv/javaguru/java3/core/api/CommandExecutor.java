package lv.javaguru.java3.core.api;

import lv.javaguru.java3.core.api.commands.DomainCommand;
import lv.javaguru.java3.core.api.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}
