package by.epamtr.totalizator.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.totalizator.command.Command;
import by.epamtr.totalizator.command.exception.CommandException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COMMAND_NAME = "command";
	private final CommandProvider provider = new CommandProvider();
	private final static Logger rootLogger = LogManager.getRootLogger();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String commandName = null;
		Command command = null;
		String page = null;

		commandName = request.getParameter(COMMAND_NAME);
		command = provider.getCommand(commandName);
		try {
			command.execute(request, response);
		} catch (CommandException e) {
			rootLogger.error(e.getMessage());
			page = PageName.ERROR_PAGE; // might be fatal eror or some other
										// page
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				rootLogger.error(e.getMessage());
			} catch (IOException e) {
				rootLogger.error(e.getMessage());
			}
		}

	}

}
