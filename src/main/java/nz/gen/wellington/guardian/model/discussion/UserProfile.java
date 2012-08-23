package nz.gen.wellington.guardian.model.discussion;

public class UserProfile {
	
	private final long id;
	private final String displayName;
	
	public UserProfile(long id, String displayName) {
		this.id = id;
		this.displayName = displayName;
	}

	public long getId() {
		return id;
	}

	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", displayName=" + displayName + "]";
	}
	
}
