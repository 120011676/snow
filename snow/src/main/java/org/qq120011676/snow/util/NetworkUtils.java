package org.qq120011676.snow.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkUtils {

	public static String getMAC(String ip) throws SocketException,
			UnknownHostException {
		return NetworkUtils.getByteToHex(NetworkInterface.getByInetAddress(
				InetAddress.getByName(ip)).getHardwareAddress());
	}

	public static String getByteToHex(byte[] bytes) {
		String stmp;
		StringBuilder sb = new StringBuilder();
		int length = bytes.length;
		for (int i = 0; i < length; i++) {
			stmp = Integer.toHexString(bytes[i] & 0xFF);
			sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
			if (i < length - 1) {
				sb.append(":");
			}
		}
		return sb.toString().toUpperCase().trim();
	}
}
