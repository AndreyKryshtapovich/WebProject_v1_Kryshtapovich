package by.epamtr.totalizator.service;

import by.epamtr.totalizator.bean.entity.User;
import by.epamtr.totalizator.service.exception.ServiceException;

public interface GeneralOperationService {
	
	User signIn (String login, String password) throws ServiceException;
}
