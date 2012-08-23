package nz.gen.wellington.guardian.model.discussion;

import java.util.Date;

public class Comment {

	private final long id;
	private final String body;
	private final Date date;
	private final String status;
	private final UserProfile userProfile;
	
	public Comment(long id, String body, Date date, String status, UserProfile userProfile) {
		this.id = id;
		this.body = body;
		this.date = date;
		this.status = status;
		this.userProfile = userProfile;
	}

	public long getId() {
		return id;
	}

	public String getBody() {
		return body;
	}

	public Date getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", body=" + body + ", date=" + date
				+ ", status=" + status + ", userProfile=" + userProfile + "]";
	}
	
}
