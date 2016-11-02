package by.epamtr.totalizator.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.totalizator.command.Command;
import by.epamtr.totalizator.controller.PageName;

public class GoToRegistrationCommand implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String url = "Controller?command=go-to-registration";
		request.getSession(false).setAttribute("currentUrl", url);

		RequestDispatcher dispatcher = request.getRequestDispatcher(PageName.REGISTRATION);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			rootLogger.error("Failed forwarding to the page");
		} catch (IOException e) {
			rootLogger.error("Failed forwarding to the page");
		}

	}

}
