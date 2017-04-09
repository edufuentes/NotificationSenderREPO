package ve.com.digitel.notificationsender.exceptions;

import static ve.com.digitel.notificationsender.util.Key.EXCEPTION_CODE;
import static ve.com.digitel.notificationsender.util.Key.EXCEPTION_DESCRIPTION;
import static ve.com.digitel.notificationsender.util.Key.EXCEPTION_TRACE;

import java.util.Map;

import org.apache.log4j.Logger;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.notificationsender.util.Key;
import ve.com.digitel.notificationsender.util.Utils;

public class ErrorHandlerServices implements IErrorHandler<Map<Key, Object>> {
	
	private static final long serialVersionUID = -7156103433446477200L;

	private Logger logger = BSSIntLogger.getBSSIntLogger (ErrorHandlerServices.class);

	public ErrorHandlerServices () {
		super ();
	}

	@Override
	public void handler (Throwable err, Map<Key, Object> context) {

		logger.error( Utils.concat((String)context.get(EXCEPTION_CODE), (String)context.get(EXCEPTION_DESCRIPTION)), err);
		
		context.put(EXCEPTION_TRACE, err.toString());

	}
	
}