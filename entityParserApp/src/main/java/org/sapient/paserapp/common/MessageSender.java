package org.sapient.paserapp.common;

/**
 * Responsibility to send message to the provided endPoint.
 * @author OM SINGH
 *
 * @param <V>
 */
public interface MessageSender<V>
{
	public void sendMessage(String endPoint, V value);
}
