/**
 * 
 */
package ramp.sample.crashextract.mysql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Rama Palaniappan
 * @since Dec 9, 2014
 */
public abstract class BaseDAO {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
}