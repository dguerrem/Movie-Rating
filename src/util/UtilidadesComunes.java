package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class UtilidadesComunes extends Properties {

	private static final long serialVersionUID = 1L;
	private static InputStream input = null;
	private static Properties prop = new Properties();
	private static Locale currentLocale = Locale.getDefault();
	private static String ruta = "src/labels/" + currentLocale.getLanguage().toUpperCase() + "_labels.properties";

	public static String getConstante(String palabra) {
		try {
			input = new FileInputStream(ruta);
			prop.load(input);
			return (prop.getProperty(palabra));
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
