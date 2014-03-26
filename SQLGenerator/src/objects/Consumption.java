package objects;

/**
 * 
 * @author TsvetanSpasov
 * @version 1.0
 */
public class Consumption {
	private String deviceID;
	private boolean carbonNeutral;
	private float value;

	/**
	 * @param deviceID
	 * @param carbonNeutral
	 * @param value
	 */
	public Consumption(String deviceID, boolean carbonNeutral, float value) {
		setDeviceID(deviceID);
		setCarbonNeutral(carbonNeutral);
		setValue(value);
	}

	/**
	 * @return the deviceID
	 */
	public String getDeviceID() {
		StringBuilder b = new StringBuilder().append("'");
		b.append(deviceID).append("'");
		return b.toString();
	}

	/**
	 * @return the carbonNeutral
	 */
	public boolean isCarbonNeutral() {
		return carbonNeutral;
	}

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param deviceID
	 *            the deviceID to set
	 */
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	/**
	 * @param carbonNeutral
	 *            the carbonNeutral to set
	 */
	public void setCarbonNeutral(boolean carbonNeutral) {
		this.carbonNeutral = carbonNeutral;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}
}
