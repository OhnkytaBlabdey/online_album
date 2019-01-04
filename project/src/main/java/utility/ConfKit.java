package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class ConfKit {

	String conf_path;
	Properties m_properties;
	static ConfKit confKit;
	
	public static void main(String[] args) {

	}
	
	public ConfKit(String path) {
		conf_path=path;
		FileReader f_conf=null;
		m_properties=new Properties();
		try {
			f_conf=new FileReader(conf_path);
			m_properties.load(f_conf);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(f_conf!=null)
				try {
					f_conf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
	
	Properties getPS() {
		return m_properties;
	}
	static public void init() {
		if(confKit==null)
			confKit=new ConfKit(Global.conf_path);
	}
	
	public static String getProperty(String key) {
		if(confKit==null) init();
		return confKit.m_getProperty(key);
	}
	
	String m_getProperty(String key) {
		System.out.println(key + " : "+m_properties.getProperty(key));
		return m_properties.getProperty(key);
	}

}
