package dt.b190043.demoproject.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="productId")
public class Mobile extends Product {

	private String ram;
	private String processor;
	private String battery;
	private String dimensions;
	private String screen;

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Mobile [ram=" + ram + ", processor=" + processor + ", battery=" + battery + ", dimensions=" + dimensions
				+ ", screen=" + screen + ", productId=" + productId + ", brand=" + brand + ", model=" + model + ", mrp="
				+ mrp + ", warranty=" + warranty + ", warrantyInMonths=" + warrantyInMonths + ", user=" + user + "]";
	}

	
	
	

}
