package ve.com.digitel.notificationsender.delegator.rules;

import java.util.Map;

import ve.com.digitel.notificationsender.util.Key;



public class RuleException extends RuntimeException {

	private static final long serialVersionUID = -3582278201216675408L;
	
	private Map<Key, Object> context;
	
	public RuleException() {
		super();
	}
	
	public RuleException(Map<Key, Object> context) {
		super();
		this.context = context;
	}
	
	public Map<Key, Object> getContext() {
		return context;
	}
	
	public void setContext(Map<Key, Object> context) {
		this.context = context;
	}

}
