package nz.gen.wellington.guardian.model;

import java.io.Serializable;

public class Refinement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	final private String type;
	final private String id;
	final private String displayName;
	final private String refinedUrl;
	final private int count;
		
	public Refinement(String type, String id, String displayName, String refinedUrl, int count) {
		this.type = type;
		this.id = id;
		this.displayName = displayName;
		this.refinedUrl = refinedUrl;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getRefinedUrl() {
		return refinedUrl;
	}

	public int getCount() {
		return count;
	}
	
}
