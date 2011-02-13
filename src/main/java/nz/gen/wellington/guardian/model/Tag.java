package nz.gen.wellington.guardian.model;

import java.io.Serializable;

public class Tag implements Serializable {
	
	private static final long serialVersionUID = 3L;
	
	final private String name;
	final private String id;
	final private Section section;
	final private String type;

	public Tag(String name, String id, Section section, String type) {
		this.name = name;
		this.id = id;
		this.section = section;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id;
	}

	public Section getSection() {
		return section;
	}
	
	public String getType() {
		return type;
	}

	public boolean isSectionKeyword() {
		if (section != null) {
			final String sectionTagId = section.getId() + "/" + section.getId();
			return id.equals(sectionTagId);			
		}
		return false;
	}

	public boolean isContributorTag() {
		return id != null && id.startsWith("profile/");
	}

	public boolean isContentTypeTag() {
		return id != null && id.startsWith("type/");
	}

	public boolean isGalleryTag() {
		return id != null && id.equals("type/gallery");
	}
	
}
