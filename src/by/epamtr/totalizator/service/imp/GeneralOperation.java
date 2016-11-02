package by.epamtr.totalizator.service.imp;

import by.epamtr.totalizator.bean.entity.User;
import by.epamtr.totalizator.dao.DAOFactory;
import by.epamtr.totalizator.dao.GeneralDAO;
import by.epamtr.totalizator.dao.exception.DAOException;
import by.epamtr.totalizator.service.GeneralOperationService;
import by.epamtr.totalizator.service.exception.ServiceException;

public class GeneralOperation implements GeneralOperationService {

	@Override
	public User signIn(String login, String password) throws ServiceException {
		User user;
		if (!Validator.loginValidation(login, password)) {
			throw new ServiceException("invalid login or password.");
		}
		DAOFactory factory = DAOFactory.getInstance();
		GeneralDAO generalDAO = factory.getDBGeneralDAO();
		try {
			user = generalDAO.signInCheck(login, password);
		} catch (DAOException e) {
			throw new ServiceException("Failed signing in.", e);
		}
		return user;
	}

}
