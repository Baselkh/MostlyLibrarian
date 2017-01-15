/**
 * 
 */
package server.ui;

import java.util.HashMap;
import java.util.Map;

import messages.MessageType;
import message.handlers.AbstractRequestHandler;
import message.handlers.HandlerFactory;
import server.db.DBConnector;

/**
 * Contain all handlers
 * 
 * @author wardm 
 *
 */
public class Handlers {

	/**
	 * Instance of DB Connections
	 */
	private DBConnector dbCon;

	/**
	 * Handlers Container
	 */
	private Map<MessageType, AbstractRequestHandler> handlers;

	/**
	 * Ctor
	 * 
	 * @param dbCon
	 */
	public Handlers(DBConnector dbCon) {
		super();
		this.dbCon = dbCon;
		handlers = new HashMap<MessageType, AbstractRequestHandler>();
	}

	/**
	 * Get Handler
	 * 
	 * @param msg
	 * @return
	 */
	public AbstractRequestHandler getHandler(MessageType msg) {
		AbstractRequestHandler handler = handlers.get(msg);
		if (handler == null) {
			handler = HandlerFactory.create(msg, dbCon);
			handlers.put(msg, handler);
		}
		return handler;
	}
}
