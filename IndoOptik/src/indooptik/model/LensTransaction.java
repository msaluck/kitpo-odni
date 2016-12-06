package indooptik.model;

public class LensTransaction {

	Integer id;
	Integer idTRansaction;
	Integer idLens;
	String axis;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdTRansaction() {
		return idTRansaction;
	}
	public void setIdTRansaction(Integer idTRansaction) {
		this.idTRansaction = idTRansaction;
	}
	public Integer getIdLens() {
		return idLens;
	}
	public void setIdLens(Integer idLens) {
		this.idLens = idLens;
	}
	public String getAxis() {
		return axis;
	}
	public void setAxis(String axis) {
		this.axis = axis;
	}
}
