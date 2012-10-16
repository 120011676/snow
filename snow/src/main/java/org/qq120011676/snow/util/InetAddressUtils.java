package org.qq120011676.snow.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class InetAddressUtils {

	public static InetAddress getInetAddress() throws UnknownHostException {
		return InetAddress.getLocalHost();
	}

	public static List<InetAddress> getInetAddressByList() throws SocketException {
		List<InetAddress> list = new ArrayList<InetAddress>();
		Enumeration<NetworkInterface> enumeration = NetworkInterface
				.getNetworkInterfaces();
		while (enumeration.hasMoreElements()) {
			NetworkInterface networkInterface = enumeration.nextElement();
			Enumeration<InetAddress> enumerationInetAddress = networkInterface
					.getInetAddresses();
			while (enumerationInetAddress.hasMoreElements()) {
				list.add(enumerationInetAddress.nextElement());
			}
		}
		return list;
	}
}
