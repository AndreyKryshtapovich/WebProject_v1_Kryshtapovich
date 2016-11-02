package by.epamtr.totalizator.service.imp;

import java.util.List;

import by.epamtr.totalizator.bean.entity.Event;
import by.epamtr.totalizator.bean.entity.User;
import by.epamtr.totalizator.dao.ClientDAO;
import by.epamtr.totalizator.dao.DAOFactory;
import by.epamtr.totalizator.dao.exception.DAOException;
import by.epamtr.totalizator.service.ClientOperationService;
import by.epamtr.totalizator.service.exception.ServiceException;

public class ClientOperation implements ClientOperationService {

	@Override
	public boolean RegistrationUser(String firstName, String lastName, String login, String password,
			String repPassword, String sex, String eMail, String country, String city, String address)
			throws ServiceException {

		boolean result = true;
		if (!Validator.userInfoValidation(firstName, lastName, login, password, repPassword, sex, eMail, country, city,
				address)) {
			throw new ServiceException("invalid parameters.");
		}


		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.seteMail(eMail);
		user.setCountry(country);
		user.setSex(sex);
		if (city.isEmpty()) {
			user.setCity(null);
		}else{
			user.setCity(city);
		}

		if (address.isEmpty()) {
			user.setAddress(null);
		}else{
			user.setAddress(address);
		}
		user.setRole("user");


		DAOFactory factory = DAOFactory.getInstance();
		ClientDAO clientDAO = factory.getDBClientDAO();

		try {
			if (!clientDAO.RegistrationUser(user, login, repPassword)) {
				result = false;
			}
		} catch (DAOException e) {
			throw new ServiceException("Failed registration.", e);
		}
		return result;

	}

	@Override
	public List<Event> showEvents() throws ServiceException {
		
		List<Event> eventsList = null;
		DAOFactory factory = DAOFactory.getInstance();
		ClientDAO clientDAO = factory.getDBClientDAO();
		
		try {
			eventsList = clientDAO.getCurrentEvents();
		} catch (DAOException e) {
			throw new ServiceException("Failed showing events.", e);
		}
		return eventsList;
	}

}
