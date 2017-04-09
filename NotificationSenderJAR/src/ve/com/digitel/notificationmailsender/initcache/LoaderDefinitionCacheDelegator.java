package ve.com.digitel.notificationmailsender.initcache;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.apache.log4j.Logger;

import ve.com.digitel.bssint.log.BSSIntLogger;
import ve.com.digitel.notificationsender.util.StructCache;
import ve.com.digitel.notificationsender.util.TemplateCache;
import ve.com.digitel.notificationsender.util.AppProperties;

public class LoaderDefinitionCacheDelegator implements Serializable {

	/**
	 * Version Serial de la Clase
	 */
	private static final long serialVersionUID = 8680729697230548214L;

	/**
	 *  DataSource
	 */
	private DataSource dataSource;
	
	
	/**
	 * Logger
	 */
	private Logger logger = BSSIntLogger.getBSSIntLogger(LoaderDefinitionCacheDelegator.class);

	// Public constructor declarations.
	/**
	 * 
	 * <p>
	 * Unique constructor without parameters.
	 */
	public LoaderDefinitionCacheDelegator() {
		// Call to super class.
		super();
	}
	
	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// Public instance method declarations.
	/**
	 * 
	 * <p>
	 * Method that return the map instance with day rule values.
	 * 
	 * @return A map with rule day values.
	 */
	@SuppressWarnings("unchecked")
	public Map<String, TemplateCache> loadDefinitionCache() throws Exception {
		/*
		 * Load the response values into map.
		 */
		
		 Map<String, TemplateCache> mapTemplateCache = new HashMap<String,TemplateCache>();
		 
		 
		//the JDBC callableStatement object
			CallableStatement callStat = null;

			Connection conn = null;

			//the JDBC Name Stored Procedure
			String procedureName = null;

			// Se obtiene el nombre del StoreProcedure.
			procedureName = AppProperties.getProperty("SP_LOAD_DATA_CACHE");

			// Se asigna la variable callStat para invocar el paquete en la base de datos

			//ds = (DataSource) AppObjectFactory.getInstance().getObject("dataSource");

			conn = dataSource.getConnection();

			callStat = conn.prepareCall(procedureName);

			ArrayDescriptor descripOUT =  ArrayDescriptor.createDescriptor("CT_RULE_NOTICE", conn);
			callStat.registerOutParameter(1, OracleTypes.ARRAY, descripOUT.getName());
			callStat.registerOutParameter(2, OracleTypes.VARCHAR);
			callStat.registerOutParameter(3, OracleTypes.VARCHAR);

			if(logger.isDebugEnabled())
				logger.debug("Ejecutando al StoredProcedure: ".concat(procedureName));

			callStat.execute();
			
			
			String codError = callStat.getString(2);
			String msgError = callStat.getString(3);
			
			
			
			if(codError != null && msgError != null){
				logger.error("codError: " + codError + " msgError: " + msgError);
				throw new SQLException("Ocurio un error al Cargar el Objeto Cache: " + codError + msgError);				
			}else{
				oracle.sql.ARRAY array = null;
				if (callStat.getArray(1) instanceof oracle.sql.ARRAY ) {
					if(logger.isDebugEnabled())				
						logger.debug("Arreglo interno, Instancia de: " + callStat.getArray(1).getClass().getName());
					
					array = (ARRAY) callStat.getArray(1);					
				}else if(callStat.getArray(1) instanceof weblogic.jdbc.wrapper.Array ){
					if(logger.isDebugEnabled())				
						logger.debug("Arreglo interno, Instancia de: " + callStat.getArray(1).getClass().getName());
					
					array = (ARRAY) ( ((weblogic.jdbc.wrapper.Array) callStat.getArray(1)).unwrap(oracle.sql.ARRAY.class));					
				}else{
								
						logger.error("Arreglo interno distinto, Instancia de: " + callStat.getArray(1).getClass().getName());
					
				}

				if(logger.isDebugEnabled()){
					logger.debug("Arreglo es del tipo de dato defino en la BD como:  " + array.getSQLTypeName());  
					logger.debug("Arreglo length: " + array.length());
				}

				Object[] arrayBA = (Object[])array.getArray();

				if(logger.isDebugEnabled())
					logger.debug("Size de arrayBA: " + arrayBA.length);
				
				String value = null;
				
				TemplateCache templateCache =  new TemplateCache();
				StructCache structCache = null;

				oracle.sql.STRUCT templateArray = null;

				for(int j = 0 ; j < arrayBA.length; j++){

//					T_CODE_NT VARCHAR2(30),
//					T_MESSAGE_NT VARCHAR2(500), 
//					T_DESTINATARY_NT VARCHAR2(200),
//					T_NOTICE_TYPE_NT VARCHAR2(20)
//					T_MESSAGE_SUBJECT_NT VARCHAR(100));

					
					templateArray = (oracle.sql.STRUCT)arrayBA[j];

					if(logger.isDebugEnabled()){				
						logger.debug("T_CODE_NT: " + templateArray.getAttributes()[0]);
						logger.debug("T_MESSAGE_NT: " + templateArray.getAttributes()[1]);
						logger.debug("T_DESTINATARY_NT: " + templateArray.getAttributes()[2]);
						logger.debug("T_NOTICE_TYPE_NT: " + templateArray.getAttributes()[3]);
						logger.debug("T_MESSAGE_SUBJECT_NT: " + templateArray.getAttributes()[4]);
					}

					value = templateArray.getAttributes()[0]  != null ? templateArray.getAttributes()[0].toString()  : null;
					
				//	if(mapTemplateCache.containsKey(value)){
					if(templateCache.getCode().equalsIgnoreCase(value)){
						
						structCache = new StructCache();
						structCache.setCode(value);
						structCache.setMessage(templateArray.getAttributes()[1]  != null ? templateArray.getAttributes()[1].toString()  : null);
						structCache.setDestinatary(templateArray.getAttributes()[2]  != null ? templateArray.getAttributes()[2].toString()  : null);
						structCache.setNoticeType(templateArray.getAttributes()[3]  != null ? templateArray.getAttributes()[3].toString()  : null);
						structCache.setSubject(templateArray.getAttributes()[4]  != null ? templateArray.getAttributes()[4].toString()  : null);
					
						templateCache.getListStructCache().add(structCache);
						
					}else{
					
						templateCache = new TemplateCache();
						
						templateCache.setCode(value);
						
						structCache = new StructCache();
						structCache.setCode(value);
						structCache.setMessage(templateArray.getAttributes()[1]  != null ? templateArray.getAttributes()[1].toString()  : null);
						structCache.setDestinatary(templateArray.getAttributes()[2]  != null ? templateArray.getAttributes()[2].toString()  : null);
						structCache.setNoticeType(templateArray.getAttributes()[3]  != null ? templateArray.getAttributes()[3].toString()  : null);
						structCache.setSubject(templateArray.getAttributes()[4]  != null ? templateArray.getAttributes()[4].toString()  : null);
						
						templateCache.getListStructCache().add(structCache);
					}
					
					mapTemplateCache.put(value, templateCache);				
				}
			}
			
		return mapTemplateCache;
	}

}