package nz.gen.wellington.guardian.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article implements Serializable {

	private static final int ARTICLE_MAIN_PICTURE_WIDTH = 460;

	private static final long serialVersionUID = 10L;
	
	private String id;
	private String headline;
	private String byline;
	private Date pubDate;
	private String standfirst;
	private String description;
	private String thumbnail;
	
	private Section section;
	
	private List<Tag> tags;
	private String webUrl;
	private String shortUrl;
	
	private boolean isRedistributionAllowed;
	
	private List<MediaElement> mediaElements;
 	
	public Article() {
		tags = new ArrayList<Tag>();
		mediaElements = new ArrayList<MediaElement>();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeadline() {
		return headline;
	}

	public String getStandfirst() {
		return standfirst;
	}

	public void setStandfirst(String standfirst) {
		this.standfirst = standfirst;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date date) {
		this.pubDate = date;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public String getMainImageUrl() {
		if (getMainPictureMediaElement() != null) {
			return getMainPictureMediaElement().getFile();
		}
		return null;
	}
	
	public String getByline() {
		return byline;
	}

	public void setByline(String byline) {
		this.byline = byline;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public boolean isRedistributionAllowed() {
		return isRedistributionAllowed;
	}

	public void setRedistributionAllowed(boolean isRedistributionAllowed) {
		this.isRedistributionAllowed = isRedistributionAllowed;
	}
	
	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
		
	public String getTrailImageCallBackLabelForArticle() {
		return id != null ? id : headline;
	}
	
	public void addMediaElement(MediaElement mediaElement) {
		mediaElements.add(mediaElement);
	}
	
	public List<MediaElement> getMediaElements() {
		return mediaElements;
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
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isGallery() {
		Tag contentTag = this.getContentTag();
		return contentTag != null && contentTag.getId().equals("type/gallery");
	}

	private Tag getContentTag() {
		for (Tag tag : this.tags) {
			if (tag.isContentTypeTag()) {
				return tag;
			}
		}
		return null;
	}
	
	
	public List<Tag> getContributorTags() {
		List<Tag> contributors = new ArrayList<Tag>();
		for (Tag tag : tags) {
			if (tag.isContributorTag()) {
				contributors.add(tag);
			}
		}
		return contributors;
	}
	
	
	public boolean isTagged() {
		if (tags.isEmpty()) {
			return false;
		}
		for (Tag tag : tags) {
			if (!tag.isContentTypeTag()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasSectionTag() {
		for (Tag tag : tags) {
			if (tag.isSectionKeyword()) {
				return true;
			}
		}
		return false;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnailUrl(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public MediaElement getMainPictureMediaElement() {
		for (MediaElement mediaElement : mediaElements) {
			if (mediaElement.getType() != null && mediaElement.getWidth() != null) {
				if (mediaElement.getType().equals("picture") && mediaElement.getWidth() == ARTICLE_MAIN_PICTURE_WIDTH) {
					return mediaElement;
				}
			}
		}
		return null;
	}
	
}
