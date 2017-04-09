package ve.com.digitel.notificationsender.util.xstream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class XMLGregorianCalendarConverter implements Converter {
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ");

	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
		
		XMLGregorianCalendar calendar = (XMLGregorianCalendar)value;
        Date date = calendar.toGregorianCalendar().getTime();
        writer.setValue(simpleDateFormat.format(date));
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {

         try {
        	 GregorianCalendar calendar = new GregorianCalendar();
             calendar.setTime(simpleDateFormat.parse(reader.getValue()));
             return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
                 
         } catch (ParseException e) {
                 throw new ConversionException(e.getMessage(), e);
         } catch (DatatypeConfigurationException e) {
        	 throw new ConversionException(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean canConvert(Class clazz) {
		return XMLGregorianCalendar.class.isAssignableFrom(clazz);
	}

}
