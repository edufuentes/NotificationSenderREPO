package ve.com.digitel.notificationsender.util.xstream;

import com.thoughtworks.xstream.XStream;

public final class XStreamFactory {
	
	private XStreamFactory() {}
	
	static public XStream makeXStream() {
		
		XStream stream = new XStream();
		stream.registerConverter(new CalendarConverter());
		stream.registerConverter(new XMLGregorianCalendarConverter());
		
		return stream;
	}

}
