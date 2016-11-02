package by.epamtr.totalizator.service;

import java.util.List;

import by.epamtr.totalizator.bean.entity.Event;
import by.epamtr.totalizator.service.exception.ServiceException;

public interface ClientOperationService {
	boolean RegistrationUser(String firstName, String lastName, String login, String password,String repPassword, String sex,
			String eMail,String country,String city,String address) throws ServiceException ;
	List<Event> showEvents() throws ServiceException;
}
