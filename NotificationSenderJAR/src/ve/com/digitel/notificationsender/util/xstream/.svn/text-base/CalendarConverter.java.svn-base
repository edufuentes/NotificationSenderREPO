package ve.com.digitel.notificationsender.util.xstream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CalendarConverter implements Converter {
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ");

	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
		
        Calendar calendar = (Calendar)value;
        Date date = calendar.getTime();
        writer.setValue(simpleDateFormat.format(date));
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
		
		 GregorianCalendar calendar = new GregorianCalendar();

         try {
                 calendar.setTime(simpleDateFormat.parse(reader.getValue()));
         } catch (ParseException e) {
                 throw new ConversionException(e.getMessage(), e);
         }
         
         return calendar;

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean canConvert(Class clazz) {
		return Calendar.class.isAssignableFrom(clazz);
	}

}
