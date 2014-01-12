package school.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MD5Encrypt {

	public static String hashPassword(String password) {

		final Logger LOGGER = Logger.getLogger(MD5Encrypt.class.getName());

		String hashword = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			BigInteger hash = new BigInteger(1, md5.digest());
			hashword = hash.toString(16);
		} catch (NoSuchAlgorithmException nsae) {
			LOGGER.log(Level.SEVERE, nsae.getMessage());
		}
		return hashword;
	}
}
