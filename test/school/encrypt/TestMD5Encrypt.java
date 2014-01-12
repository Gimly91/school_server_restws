package school.encrypt;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMD5Encrypt {
	
	@Test
	public void hashPassword(){
		String password = "123456";
		String encrypted = "e10adc3949ba59abbe56e057f20f883e";
		assertEquals(encrypted,MD5Encrypt.hashPassword(password));
	}
}
