package io.swagger.customizacao.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;

public class AuthUtil {

	private static final String BASIC = "Basic ";

	public static String getBasicAuth(String cpf, String password) {
		
		String cpfPassword = cpf.concat(":").concat(password);
		
		Base64 base64 = new Base64();
		
		return new String(base64.encode(cpfPassword.getBytes()));
	}

	public static String[] getBasicAuth(String auth) {

		Base64 base64 = new Base64();

		if (StringUtils.isEmpty(auth)) {
			throw new RuntimeException();
		}

		if(auth.startsWith(BASIC)) {
			auth = auth.replace(BASIC, "");
		}
		
		try {
			String decoded = new String(base64.decode(auth.getBytes()));

			if (!decoded.contains(":")) {
				throw new RuntimeException();
			}

			return new String[] { decoded.substring(0, decoded.indexOf(":")), auth};
		} catch (Exception e) {
			throw new RuntimeException("Falha ao tentar recuperar BasicAuth");
		}

	}
}
