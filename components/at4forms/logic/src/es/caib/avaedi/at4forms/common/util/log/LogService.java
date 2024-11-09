package es.caib.avaedi.at4forms.common.util.log;

import org.slf4j.LoggerFactory;

/**
 * A class to get an instance for a logger object.
 * @author  Oriol Barnes Cruz  AT4
 */
public final class LogService {

   /**
    * Get an instance of a logger object.
    * @param cls the Class to log from
    * @return Logger the logger instance
    */
   @SuppressWarnings("rawtypes")
   public static org.slf4j.Logger getLogger(Class cls) {
      return LoggerFactory.getLogger(cls);
   }

}
