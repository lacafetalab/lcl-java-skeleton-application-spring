package pe.lacafetalab.pao.shared.utils;

import org.jasypt.digest.StandardStringDigester;
import org.jasypt.digest.config.SimpleDigesterConfig;
import org.jasypt.salt.RandomSaltGenerator;

public enum SecurityEncription {
	
	INSTANCE;
	
	private static final String ENCODING = "base64";
	private static final String ALGORITHM = "SHA-256";
	
	private final StandardStringDigester digester;
	
	private SecurityEncription() {
		SimpleDigesterConfig config = new SimpleDigesterConfig();
		config.setAlgorithm(ALGORITHM);
		config.setIterations(500000);
		config.setSaltGeneratorClassName(RandomSaltGenerator.class.getName());
		digester = new StandardStringDigester();
		digester.setConfig(config);
		digester.setStringOutputType(ENCODING);
		digester.initialize();
	}
	
	public String digest(String source) {
		return digester.digest(source);
	}
	
}
