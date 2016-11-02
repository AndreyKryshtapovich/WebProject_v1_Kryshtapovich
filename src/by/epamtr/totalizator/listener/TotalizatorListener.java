package by.epamtr.totalizator.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.totalizator.connectionpool.ConnectionPool;
import by.epamtr.totalizator.connectionpool.exception.ConnectionPoolException;

public class TotalizatorListener implements ServletContextListener {

	private ConnectionPool connectionPool = ConnectionPool.getInstance();
	private final static Logger rootLogger =  LogManager.getRootLogger();
   
	public TotalizatorListener() {}

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	connectionPool.dispose();
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
       try {
		connectionPool.initPoolData();
	} catch (ConnectionPoolException e) {
		rootLogger.error(e.getMessage());
	}
    }

}
