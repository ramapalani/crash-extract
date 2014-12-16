//Copied and modified from crashreport-dao project
package ramp.sample.crashextract.mysql.model;

import java.util.Date;

public class CrashInstance implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long crashInstanceId;
	private Long appVerId;;
	private String uniqueCrashMd5;;
	private String osVer;
	private String deviceName;
	private String clientName;
	private String deviceId;
	private String pushId;
	private String stackTrace;
	private String rawStackTrace;
	private String userId;
	private String phoneNumber;
	private String coreDumpFileLocation;
	private boolean isSymbolicated;
	private Integer releaseTypeId;
	private String otherData;
	private Date crashedTimestamp;
	private Date createdTimestamp;
	private Date lastUpdatedTimestamp;
	
	public CrashInstance() {
	}
	public Long getCrashInstanceId() {
		return this.crashInstanceId;
	}

	public void setCrashInstanceId(Long crashInstanceId) {
		this.crashInstanceId = crashInstanceId;
	}

	public Long getAppVerId() {
		return this.appVerId;
	}

	public void setAppVer(Long appVerId) {
		this.appVerId = appVerId;
	}

	public String getUniqueCrash() {
		return this.uniqueCrashMd5;
	}

	public void setUniqueCrash(String uniqueCrashMd5) {
		this.uniqueCrashMd5 = uniqueCrashMd5;
	}

	public String getOsVer() {
		return this.osVer;
	}

	public void setOsVer(String osVer) {
		this.osVer = osVer;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPushId() {
		return this.pushId;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public String getStackTrace() {
		return this.stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	
	public String getRawStackTrace() {
		return this.rawStackTrace;
	}

	public void setRawStackTrace(String rawStackTrace) {
		this.rawStackTrace = rawStackTrace;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCoreDumpFileLocation() {
		return this.coreDumpFileLocation;
	}

	public void setCoreDumpFileLocation(String coreDumpFileLocation) {
		this.coreDumpFileLocation = coreDumpFileLocation;
	}

	public boolean isIsSymbolicated() {
		return this.isSymbolicated;
	}

	public void setIsSymbolicated(boolean isSymbolicated) {
		this.isSymbolicated = isSymbolicated;
	}
	
	public Integer getReleaseType() {
		return this.releaseTypeId;
	}

	public void setReleaseTypeId(Integer releaseTypeId) {
		this.releaseTypeId = releaseTypeId;
	}

	public String getOtherData() {
		return this.otherData;
	}

	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}

	public Date getCrashedTimestamp() {
		return this.crashedTimestamp;
	}

	public void setCrashedTimestamp(Date crashedTimestamp) {
		this.crashedTimestamp = crashedTimestamp;
	}

	public Date getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getLastUpdatedTimestamp() {
		return this.lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}
}
