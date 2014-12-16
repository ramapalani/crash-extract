/**
 * 
 */
package ramp.sample.crashextract.mysql.dao;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import ramp.sample.crashextract.mysql.model.CrashInstance;
import ramp.sample.crashextract.types.NameValuePair;
import ramp.sample.crashextract.types.OtherData;

/**
 * @author Rama Palaniappan
 * @since Dec 9, 2014
 */
@SuppressWarnings("restriction")
@Repository("crashInstanceDao")
public class CrashInstanceDaoImpl extends BaseDAO implements CrashInstanceDao {

	private static final Log LOG = LogFactory
			.getLog(CrashInstanceDaoImpl.class);
	private static JAXBContext jaxbContext = null;

	private static final String SELECT_CRASH_INSTANCE = "SELECT * FROM crash_instance";
	private static final Set<String> includeNames = new HashSet<String>();

	static {
		try {
			jaxbContext = JAXBContext.newInstance(OtherData.class);
		} catch (JAXBException e) {
			LOG.error("Error instantiating jaxbcontext", e);
		}
		includeNames.add("BRAND");
		includeNames.add("MANUFACTURER");
		includeNames.add("MODEL");
		includeNames.add("PRODUCT");
		includeNames.add("AVAILABLE_MEM_SIZE");
		includeNames.add("TOTAL_MEM_SIZE");
		includeNames.add("APP_VERSION_CODE");
		//These nested configs are included
		includeNames.add("CRASH_CONFIGURATION");
		includeNames.add("SETTINGS_SECURE");
		includeNames.add("SETTINGS_SYSTEM");
		//These name-value pairs from nested configs are required
		includeNames.add("CRASH_CONFIGURATION-orientation");
		includeNames.add("CRASH_CONFIGURATION-locale");
		includeNames.add("SETTINGS_SECURE-WIFI_ON");
		includeNames.add("SETTINGS_SECURE-MOBILE_DATA");
		includeNames.add("SETTINGS_SECURE-BLUETOOTH_ON");
		includeNames.add("SETTINGS_SECURE-BLUETOOTH_ON");
		includeNames.add("SETTINGS_SECURE-BLUETOOTH_ON");
		includeNames.add("SETTINGS_SECURE-BLUETOOTH_ON");
		includeNames.add("SETTINGS_SYSTEM-AIRPLANE_MODE_ON");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void find() {
		List<CrashInstance> crashInstances = jdbcTemplate.query(
				SELECT_CRASH_INSTANCE, new BeanPropertyRowMapper(
						CrashInstance.class));
		// LOG.info("CrashInstances: " + crashInstances.get(1).getOtherData());
		OtherData otherData = null;
		try {
			otherData = getOtherData(crashInstances.get(6).getOtherData());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		List<NameValuePair> flatOtherData = new ArrayList<NameValuePair>();
		flattenOtherData(otherData.getNVPS(), null, flatOtherData);
		printNameValuePairs(flatOtherData);

	}

	public OtherData getOtherData(String otherDataString) throws JAXBException {
		if (otherDataString == null) {
			return null;
		}
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(otherDataString);
		Object obj = unmarshaller.unmarshal(reader);

		if (obj == null || !(obj instanceof OtherData)) {
			return null;
		}
		return (OtherData) obj;
	}

	public void flattenOtherData(List<NameValuePair> rawNameValuePairs,
			String parentName, List<NameValuePair> flatOtherData) {
		if (rawNameValuePairs == null || rawNameValuePairs.size() == 0) {
			return;
		}
		for (NameValuePair nvp : rawNameValuePairs) {
			String name = null;
			if (parentName != null) {// nested NVP
				name = parentName + "-" + nvp.getN();
			} else {
				name = nvp.getN();
			}
			if (name == null || !includeNames.contains(name)) {
				continue;
			}
			List<NameValuePair> nestedNameValuePairs = nvp.getNVPS();
			if (nestedNameValuePairs != null && nestedNameValuePairs.size() > 0) {
				flattenOtherData(nestedNameValuePairs, name, flatOtherData);
			} else {
				if (flatOtherData == null) {
					flatOtherData = new ArrayList<NameValuePair>();
				}
				nvp.setN(name);
				flatOtherData.add(nvp);
			}
		}
	}
	
	private void printNameValuePairs(List<NameValuePair> nvps) {
		if (nvps == null || nvps.size() == 0) {
			return;
		}
		for (NameValuePair nvp: nvps) {
//			LOG.info(nvp.getN() +"=" + nvp.getV());
			System.out.println(nvp.getN() +"=" + nvp.getV());
		}
	}
}
