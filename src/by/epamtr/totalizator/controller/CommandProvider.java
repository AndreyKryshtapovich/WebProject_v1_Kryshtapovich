package by.epamtr.totalizator.controller;

import java.util.HashMap;
import java.util.Map;
import by.epamtr.totalizator.command.Command;
import by.epamtr.totalizator.command.CommandName;
import by.epamtr.totalizator.command.impl.GoToRegistrationCommand;
import by.epamtr.totalizator.command.impl.RegistrationUserCommand;
import by.epamtr.totalizator.command.impl.ShowEventsCommand;
import by.epamtr.totalizator.command.impl.SignInCommand;
import by.epamtr.totalizator.command.impl.SignOutCommand;
import by.epamtr.totalizator.command.impl.UnknownCommand;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	CommandProvider() {
		commands.put(CommandName.SIGN_IN, new SignInCommand());
		commands.put(CommandName.GO_TO_REGISTRATION, new GoToRegistrationCommand());
		commands.put(CommandName.REGISTRATION_USER, new RegistrationUserCommand());
		commands.put(CommandName.SIGN_OUT, new SignOutCommand());
		commands.put(CommandName.SHOW_EVENTS, new ShowEventsCommand());
		commands.put(CommandName.UNKNOWN, new UnknownCommand());

	}

	public Command getCommand(String commandName) {

		Command command = null;
		CommandName key = CommandName.UNKNOWN;

		commandName = commandName.replace("-", "_").toUpperCase();
		CommandName[] names = CommandName.values();
		for (CommandName c : names) {
			if (commandName.equals(c.toString())) {
				key = CommandName.valueOf(commandName);
				break;
			}
		}
		command = commands.get(key);
		return command;
	}
}
