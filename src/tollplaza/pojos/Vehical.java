package tollplaza.pojos;

import java.util.Date;

public class Vehical {
protected int vId;
protected int tbId;
protected String regNo;
protected Date arrivalTime;
protected int vtId;
protected float taxCollected;
public int getvId() {
	return vId;
}
public void setvId(int vId) {
	this.vId = vId;
}
public int getTbId() {
	return tbId;
}
public void setTbId(int tbId) {
	this.tbId = tbId;
}
public String getRegNo() {
	return regNo;
}
public void setRegNo(String regNo) {
	this.regNo = regNo;
}
public Date getArrivalTime() {
	return arrivalTime;
}
public void setArrivalTime(Date arrivalTime) {
	this.arrivalTime = arrivalTime;
}
public int getVtId() {
	return vtId;
}
public void setVtId(int vtId) {
	this.vtId = vtId;
}
public float getTaxCollected() {
	return taxCollected;
}
public void setTaxCollected(float taxCollected) {
	this.taxCollected = taxCollected;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
	result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
	result = prime * result + Float.floatToIntBits(taxCollected);
	result = prime * result + tbId;
	result = prime * result + vId;
	result = prime * result + vtId;
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
	Vehical other = (Vehical) obj;
	if (arrivalTime == null) {
		if (other.arrivalTime != null)
			return false;
	} else if (!arrivalTime.equals(other.arrivalTime))
		return false;
	if (regNo == null) {
		if (other.regNo != null)
			return false;
	} else if (!regNo.equals(other.regNo))
		return false;
	if (Float.floatToIntBits(taxCollected) != Float.floatToIntBits(other.taxCollected))
		return false;
	if (tbId != other.tbId)
		return false;
	if (vId != other.vId)
		return false;
	if (vtId != other.vtId)
		return false;
	return true;
}
@Override
public String toString() {
	return "Vehical [vId=" + vId + ", tbId=" + tbId + ", regNo=" + regNo + ", arrivalTime=" + arrivalTime + ", vtId="
			+ vtId + ", taxCollected=" + taxCollected + "]";
}
public Vehical(int vId, int tbId, String regNo, Date arrivalTime, int vtId, float taxCollected) {
	super();
	this.vId = vId;
	this.tbId = tbId;
	this.regNo = regNo;
	this.arrivalTime = arrivalTime;
	this.vtId = vtId;
	this.taxCollected = taxCollected;
}
public Vehical(int tbId, String regNo, Date arrivalTime, int vtId, float taxCollected) {
	super();
	this.tbId = tbId;
	this.regNo = regNo;
	this.arrivalTime = arrivalTime;
	this.vtId = vtId;
	this.taxCollected = taxCollected;
}
public Vehical() {
	super();
}


}
