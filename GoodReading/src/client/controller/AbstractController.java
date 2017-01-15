package client.controller;

import client.ui.Client;

/**
 * @author wardm
 *
 * 
 */
public class AbstractController {

	protected Client client;

	/**
	 * Ctor
	 * 
	 * @param client
	 */
	public AbstractController(Client client) {
		super();
		this.client = client;
	}

}
