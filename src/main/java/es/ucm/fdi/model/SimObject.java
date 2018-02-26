package es.ucm.fdi.model;

import java.util.Map;

public abstract class SimObject {
	private String id;
		
	public SimObject(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SimObject other = (SimObject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	protected abstract void fillReportDetails(Map<String, String> out);
	protected abstract String getReportHeader();
	
	public void report(int time, Map<String, String> out) {
		out.put("", getReportHeader());
		out.put("id", id);
		out.put("time", Integer.toString(time));
		fillReportDetails(out);
	}
	
	/*public String toString(){ //copiado de pizarra
		StringBuilder sb= new StringBuilder("   ");
		for(Map.Entry<String,String> e : m) {
			sb.append(e.getKey() + ":" + e.getValue() + "\n\t");
		}
		return sb.toString();
	}*/
}
