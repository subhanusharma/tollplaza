package tollplaza.pojos;

public class VehicalType {
protected int vtId;
protected String vtName;
protected float vtTax;
public int getVtId() {
	return vtId;
}
public void setVtId(int vtId) {
	this.vtId = vtId;
}
public String getVtName() {
	return vtName;
}
public void setVtName(String vtName) {
	this.vtName = vtName;
}
public float getVtTax() {
	return vtTax;
}
public void setVtTax(float vtTax) {
	this.vtTax = vtTax;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + vtId;
	result = prime * result + ((vtName == null) ? 0 : vtName.hashCode());
	result = prime * result + Float.floatToIntBits(vtTax);
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
	VehicalType other = (VehicalType) obj;
	if (vtId != other.vtId)
		return false;
	if (vtName == null) {
		if (other.vtName != null)
			return false;
	} else if (!vtName.equals(other.vtName))
		return false;
	if (Float.floatToIntBits(vtTax) != Float.floatToIntBits(other.vtTax))
		return false;
	return true;
}
@Override
public String toString() {
	return "VehicalType [vtId=" + vtId + ", vtName=" + vtName + ", vtTax=" + vtTax + "]";
}
public VehicalType(int vtId, String vtName, float vtTax) {
	super();
	this.vtId = vtId;
	this.vtName = vtName;
	this.vtTax = vtTax;
}
public VehicalType() {
	super();
}
public VehicalType(String vtName, float vtTax) {
	super();
	this.vtName = vtName;
	this.vtTax = vtTax;
}


}
