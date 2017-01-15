package message.handlers;

import java.sql.SQLException;

import messages.Message;
import protocol.request.LogoutRequest;
import protocol.response.LogoutResponse;
import server.db.DBConnector;
/**
 * 
 * @author bayan
 */
public class LogoutRequestHandler extends AbstractRequestHandler {
	/**
	 * If the message request kind of LogoutRequest we call the appropriate method from the database , 
	 * <markAsLoggedOut()> make the user logged out.<P>
	 * After that we build LogoutResponse message and return it.
	 * 
	 */
	public LogoutRequestHandler(DBConnector dbCon) {
		super(dbCon);
	}
	
	@Override
	public Message handle(Message msg) {

		try {
				dbCon.markAsLoggedOut(((LogoutRequest) msg).getUser());
				LogoutResponse response = new LogoutResponse("OK");
				response.setText("Logout Successfull!!");
				return response;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return LogoutResponse.ERROR();
		}
	}


}
