package by.epamtr.totalizator.service;

import by.epamtr.totalizator.service.imp.AdminOperation;
import by.epamtr.totalizator.service.imp.ClientOperation;
import by.epamtr.totalizator.service.imp.GeneralOperation;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private GeneralOperationService generalOperatoinService = new GeneralOperation();
	private ClientOperationService clientOperatoinService = new ClientOperation();
	private AdminOperationService adminOperatoinService = new AdminOperation();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public GeneralOperationService getGeneralOperationService() {
		return generalOperatoinService;
	}

	public ClientOperationService getClientOperationService() {
		return clientOperatoinService;
	}
	
	public AdminOperationService getAdminOperationService() {
		return adminOperatoinService;
	}
}
