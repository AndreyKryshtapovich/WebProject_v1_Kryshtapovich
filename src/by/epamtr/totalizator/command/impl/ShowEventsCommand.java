package by.epamtr.totalizator.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.totalizator.bean.entity.Event;
import by.epamtr.totalizator.bean.listbean.JSPListBean;
import by.epamtr.totalizator.command.Command;
import by.epamtr.totalizator.command.exception.CommandException;
import by.epamtr.totalizator.controller.PageName;
import by.epamtr.totalizator.service.ClientOperationService;
import by.epamtr.totalizator.service.ServiceFactory;
import by.epamtr.totalizator.service.exception.ServiceException;

public class ShowEventsCommand implements Command {
	private final static Logger rootLogger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		String url = "Controller?command=show-events";
		request.getSession(false).setAttribute("currentUrl", url);

		String page = null;
		List<Event> eventsList = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		ClientOperationService clientService = factory.getClientOperationService();

		try {
			eventsList = clientService.showEvents();
		} catch (ServiceException e) {
			rootLogger.error(e.getMessage());
		}

		JSPListBean jsp = new JSPListBean(eventsList);
		request.setAttribute("list", jsp);// именуем атрибуты
		page = PageName.USER_PAGE;

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
