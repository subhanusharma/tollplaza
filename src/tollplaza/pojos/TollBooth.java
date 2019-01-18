package tollplaza.pojos;

public class TollBooth {
protected int tbId;
protected int tbNo;
protected String tbLocation;
protected String tbHandler;
protected String highway;
public int getTbId() {
	return tbId;
}
public void setTbId(int tbId) {
	this.tbId = tbId;
}
public int getTbNo() {
	return tbNo;
}
public void setTbNo(int tbNo) {
	this.tbNo = tbNo;
}
public String getTbLocation() {
	return tbLocation;
}
public void setTbLocation(String tbLocation) {
	this.tbLocation = tbLocation;
}
public String getTbHandler() {
	return tbHandler;
}
public void setTbHandler(String tbHandler) {
	this.tbHandler = tbHandler;
}
public String getHighway() {
	return highway;
}
public void setHighway(String highway) {
	this.highway = highway;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((highway == null) ? 0 : highway.hashCode());
	result = prime * result + ((tbHandler == null) ? 0 : tbHandler.hashCode());
	result = prime * result + tbId;
	result = prime * result + ((tbLocation == null) ? 0 : tbLocation.hashCode());
	result = prime * result + tbNo;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TollBooth other = (TollBooth) obj;
	if (highway == null) {
		if (other.highway != null)
			return false;
	} else if (!highway.equals(other.highway))
		return false;
	if (tbHandler == null) {
		if (other.tbHandler != null)
			return false;
	} else if (!tbHandler.equals(other.tbHandler))
		return false;
	if (tbId != other.tbId)
		return false;
	if (tbLocation == null) {
		if (other.tbLocation != null)
			return false;
	} else if (!tbLocation.equals(other.tbLocation))
		return false;
	if (tbNo != other.tbNo)
		return false;
	return true;
}
@Override
public String toString() {
	return "TollBooth [tbId=" + tbId + ", tbNo=" + tbNo + ", tbLocation=" + tbLocation + ", tbHandler=" + tbHandler
			+ ", highway=" + highway + "]";
}
public TollBooth(int tbId, int tbNo, String tbLocation, String tbHandler, String highway) {
	super();
	this.tbId = tbId;
	this.tbNo = tbNo;
	this.tbLocation = tbLocation;
	this.tbHandler = tbHandler;
	this.highway = highway;
}
public TollBooth() {
	super();
}
public TollBooth(int tbNo, String tbLocation, String tbHandler, String highway) {
	super();
	this.tbNo = tbNo;
	this.tbLocation = tbLocation;
	this.tbHandler = tbHandler;
	this.highway = highway;
}


}
