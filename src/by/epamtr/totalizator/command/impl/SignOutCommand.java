package by.epamtr.totalizator.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtr.totalizator.command.Command;
import by.epamtr.totalizator.command.exception.CommandException;
import by.epamtr.totalizator.controller.PageName;

public class SignOutCommand implements Command {
	private final static String LOGIN = "login";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String url = "Controller?command=sign-out"; 
		request.getSession(false).setAttribute("currentUrl", url);
		request.getSession(false).removeAttribute(LOGIN);
		request.getSession().invalidate();
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(PageName.INDEX_PAGE);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				throw new CommandException("Failed forwarding to the page.",e);
			} catch (IOException e) {
				throw new CommandException("Failed forwarding to the page.",e);
			}
			
			
		
	}

}
