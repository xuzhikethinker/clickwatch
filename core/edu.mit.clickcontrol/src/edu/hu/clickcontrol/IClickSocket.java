package edu.hu.clickcontrol;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import click.ClickException;
import click.ControlSocket.HandlerInfo;

import com.google.inject.ImplementedBy;

/**
 * This interface hides concrete implementation of click control sockets.
 * 
 * @author Markus Scheidgen
 */
@ImplementedBy(ClickSocketImpl.class)
public interface IClickSocket {

	/**
	 * Establishes a connection with the remote node.
	 * 
	 * It has been observed that this might take unusually long periods of time
	 * to connect when there is no route to the target node. This is a blocking
	 * call.
	 * 
	 * @param host
	 *            , host name or IP address of the remote node.
	 * @param port
	 *            , port of the click runtim on the remote node (usually 7777).
	 * @throws IOException
	 */
	void connect(InetAddress host, int port, int socketTimeOut) throws IOException;

	/**
	 * Closes the connection to the remote node. It works under the assumption
	 * that the connection is already established connected.
	 */
	void close();

	/**
	 * @return all elements of the node
	 * @throws ClickException
	 * @throws IOException
	 */
	List<String> getConfigElementNames() throws ClickException, IOException;

	/**
	 * @param name
	 *            a valid name of an existing element. Use
	 *            {@link #getConfigElementNames()} to retrieve element names.
	 * @return all infos of all the handlers in this element.
	 * @throws ClickException
	 * @throws IOException
	 */
	List<HandlerInfo> getElementHandlers(String name) throws ClickException,
			IOException;

	/**
	 * Reads a handler value. Works only for handlers that can be read.
	 * 
	 * @param elementName
	 *            , the name of the element containing the handler.
	 * @param handlerName
	 *            , the name of the handler that you want to read.
	 * @return the plain handler value
	 * @throws ClickException
	 * @throws IOException
	 */
	char[] read(String elementName, String handlerName) throws ClickException,
			IOException;

	void write(String string, String string2, char[] charArray)
			throws ClickException, IOException;

}