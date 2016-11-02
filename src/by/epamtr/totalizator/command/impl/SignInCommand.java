package by.epamtr.totalizator.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.totalizator.bean.entity.User;
import by.epamtr.totalizator.command.Command;
import by.epamtr.totalizator.command.exception.CommandException;
import by.epamtr.totalizator.controller.PageName;
import by.epamtr.totalizator.service.GeneralOperationService;
import by.epamtr.totalizator.service.ServiceFactory;
import by.epamtr.totalizator.service.exception.ServiceException;

public class SignInCommand implements Command {
	private final static String LOGIN = "login";
	private final static String PASSWORD = "password";
	private final static String USER = "user";
	private final static Logger rootLogger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;

		String url = "Controller?command=sign-in" + "&login=" + request.getParameter(LOGIN) + "&password="
				+ request.getParameter(PASSWORD);
		
		request.getSession(false).setAttribute("currentUrl", url);

		ServiceFactory factory = ServiceFactory.getInstance();
		GeneralOperationService generalService = factory.getGeneralOperationService();

		User user = null;
		try {
			user = generalService.signIn(request.getParameter(LOGIN), request.getParameter(PASSWORD));
			
			if (user == null) {
				page = PageName.INDEX_PAGE;
			} else {
				if (user.getRole().equals(USER)) {
					request.getSession(true).setAttribute(LOGIN, request.getParameter(LOGIN));
					// redirect for execution show-events command
					response.sendRedirect("http://localhost:8080/Totalizator/Controller?command=show-events");
					return;
				} else {
					request.getSession(true).setAttribute(LOGIN, request.getParameter(LOGIN));
					page = PageName.ADMIN_PAGE;
				}

			}
		} catch (ServiceException e) {
			rootLogger.error(e.getMessage());
			page = PageName.INDEX_PAGE;
		} catch (IOException e) {
			throw new CommandException("Failed forwarding to the page.", e);
		}
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			throw new CommandException("Failed forwarding to the page.", e);
		} catch (IOException e) {
			throw new CommandException("Failed forwarding to the page.", e);
		}

	}

}
