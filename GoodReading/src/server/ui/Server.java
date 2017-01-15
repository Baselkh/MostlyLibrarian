package server.ui;

import messages.Message;
import server.db.DBConnector;
import server.ocsf.AbstractServer;
import server.ocsf.ConnectionToClient;
/**
 * 
 * @author wardm
 *
 */
public class Server extends AbstractServer {
	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;
	/**
	 * Instance of DB Connection
	 */
	private DBConnector dbCon;
	/**
	 * Instance of handlers
	 */
	private Handlers handlers;

	private ServerUI serverUI;

	public Server(ServerUI serverUI) {
		super();
		this.serverUI = serverUI;
		serverUI.setVisible(true);
	}

	/**
	 * Connect to DB <p>
	 * this method is used to connect to the DB<p>
	 * it gets the info from the ClientUI and connect to the db
	 * @param host
	 * @param port
	 * @param user
	 * @param pass
	 * @return
	 */
	public boolean connectToDB(String host, String user, String pass) {
		dbCon = new DBConnector();
		try {
			dbCon.connect(host, user, pass);
			handlers = new Handlers(dbCon);
			//AutoSendMail autoSendMail=new AutoSendMail(dbCon);
			//Timer mailTime = new Timer();
//			Date mailDate=new Date();
//			mailDate.setHours(8);
//			mailDate.setMinutes(0);
			//mailTime.schedule(autoSendMail, mailDate,100*60*60*24 );
			//AutoGenerateReport auto = new AutoGenerateReport(dbCon);
//			Timer timer = new Timer();
//			Date date = new Date();
//			LocalDate date1 = LocalDate.now();
//			while(date1.getDayOfWeek()!= DayOfWeek.SUNDAY){
//				date1=date1.plusDays(1);
//			}
//			date.setDate(date1.getDayOfMonth());
//			date.setHours(00);
//			date.setMinutes(01);
			// Schedule to run every Sunday in midnight
			//timer.schedule(auto, date, 1000 * 60 * 60 * 24 * 7);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public DBConnector getDbCon() {
		return dbCon;
	}

	/**
	 * Handler incoming requests from client<p>
	 * we use this method in an abstract way<p>
	 * we get the message from the client and<p>
	 * call the suitable handler depending on<p>
	 * the MessageType <p>
	 *  
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		try {

			Message message = (Message) msg;
			serverUI.display("Recieved: " + message.getMessageType().toString());

			Message response = handlers.getHandler(message.getMessageType())
					.handle(message);

			// Send response to client
			client.sendToClient(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
