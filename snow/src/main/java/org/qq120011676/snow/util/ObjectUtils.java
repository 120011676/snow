package org.qq120011676.snow.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectUtils {

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T objectDeepClone(T t) {
		T tClone = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(out);
			oo.writeObject(t);
			ByteArrayInputStream in = new ByteArrayInputStream(
					out.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(in);
			tClone = (T) oi.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tClone;
	}

	public static boolean isNull(Object object) {
		return object == null;
	}
}
