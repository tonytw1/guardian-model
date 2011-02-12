package nz.gen.wellington.guardian.model;

import java.io.Serializable;

public class Section implements Serializable {
	
	private static final long serialVersionUID = 3L;
	
	private String id;
	private String name;
	
	public Section(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String apiUrl) {
		this.id = apiUrl;
	}
	
	public Tag getTag() {
		return new Tag(name, id + "/" + id, this, "keyword");
	}
	
}
