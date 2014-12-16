/**
 * 
 */
package ramp.sample.crashextract;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ramp.sample.crashextract.mysql.dao.CrashInstanceDao;

/**
 * @author Rama Palaniappan
 * @since Dec 9, 2014
 */
@Component("driver")
public class Driver {
	private final Log LOG = LogFactory.getLog(Driver.class);
	
	@Autowired
	private CrashInstanceDao crashInstanceDao;
	
	public void start() {
		LOG.info("Driver.start()");
		crashInstanceDao.find();
	}
}
