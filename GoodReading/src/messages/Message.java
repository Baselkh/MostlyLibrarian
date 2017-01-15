package messages;

import java.io.Serializable;

import client.entities.Book;

/**
 * @author ψεπο
 *
 */
public interface Message extends Serializable{

	/**
	 * Return Message Type
	 * 
	 * @return
	 */
	public MessageType getMessageType();

	
}
