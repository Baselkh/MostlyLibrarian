package message.handlers;

import messages.Message;
import server.db.DBConnector;

/**
 * 
 * @author wardm
 *
 */
public abstract class AbstractRequestHandler {
	/**
	 * DB Connection
	 */
	protected DBConnector dbCon;

	public AbstractRequestHandler(DBConnector dbCon) {
		this.dbCon = dbCon;
	}

	public DBConnector getDbCon() {
		return dbCon;
	}

	public void setDbCon(DBConnector dbCon) {
		this.dbCon = dbCon;
	}

	/**
	 * Implement in every handler
	 * 
	 * @param msg
	 * @return
	 */
	abstract public Message handle(Message msg);

}
