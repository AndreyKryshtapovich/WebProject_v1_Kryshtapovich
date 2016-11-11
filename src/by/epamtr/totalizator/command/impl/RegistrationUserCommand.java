package by.epamtr.totalizator.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.totalizator.command.Command;
import by.epamtr.totalizator.command.exception.CommandException;
import by.epamtr.totalizator.controller.PageName;
import by.epamtr.totalizator.service.ClientOperationService;
import by.epamtr.totalizator.service.ServiceFactory;
import by.epamtr.totalizator.service.exception.ServiceException;

public class RegistrationUserCommand implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		// а StringBuilder тебе не помог бы?
		String url = "Controller?command=registration-user&firstName=" + request.getParameter("firstName")
				+ "&lastName=" + request.getParameter("lastName") + "&login=" + request.getParameter("login")
				+ "&password=" + request.getParameter("password") + "&rep-password="
				+ request.getParameter("rep-password") + "&sex=" + request.getParameter("sex") + "&e-mail="
				+ request.getParameter("e-mail") + "&country=" + request.getParameter("country") + "&city="
				+ request.getParameter("city") + "&address=" + request.getParameter("address");

		// а тебе точно нужно созранять url запроса на регистрацию?
		// ты что, собираешь повторно перевыполнять этот url?
		request.getSession(false).setAttribute("currentUrl", url);

		String page = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		ClientOperationService clientService = factory.getClientOperationService();

		try {                                  // а чего это метод с большой буквы назван?
			boolean result = clientService.RegistrationUser(request.getParameter("firstName"),
					request.getParameter("lastName"), request.getParameter("login"), request.getParameter("password"),
					request.getParameter("rep-password"), request.getParameter("sex"), request.getParameter("e-mail"),
					request.getParameter("country"), request.getParameter("city"), request.getParameter("address"));

			if (result) {

				page = PageName.INDEX_PAGE;
			} else {
				page = PageName.REGISTRATION;
			}
		} catch (ServiceException e) {
			rootLogger.error(e.getMessage());
			page = PageName.REGISTRATION;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			throw new CommandException("Failed forwarding to the page.", e);
		} catch (IOException e) {
			throw new CommandException("Failed forwarding to the page.", e);
		}

	}

}
