package ve.com.digitel.notificationsender.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TemplateCache implements Serializable {

	/**
	 * Version Serial de la Clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Codigo de StructCache en StructCache.code
	 */
	
	private String code;
	
	
	private List<StructCache> listStructCache;
	
	
	public TemplateCache() {
		listStructCache = new ArrayList<StructCache>();
		code = new String();
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the listStructCache
	 */
	public List<StructCache> getListStructCache() {
		return listStructCache;
	}

	
}


 