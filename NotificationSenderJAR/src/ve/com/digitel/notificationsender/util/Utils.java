package ve.com.digitel.notificationsender.util;



public class Utils {
	
	static public StringBuffer LOCATOR_FACTORY_SELECTOR = 
		new StringBuffer("classpath:/ve/com/digitel/notificationsender/conf/spring/beanRefContext.xml");
	
	
	public static String concat(String... cadenas) { 

		String result = new String();
		
		for(String cadena : cadenas) {
			
			if (cadena != null && !cadena.isEmpty()) {
				result = result.isEmpty() ? cadena : result + " : " + cadena;
			}
			
		}
		
		return result.isEmpty() ? null : result;
	}
	
	
}
