package by.itacademy.matveenko.jd2.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String brief;
	private String content;
	private LocalDate date;
	private User author;
	
	public News() {
	}

	public static class Builder {
		private News newNews;

		public Builder() {
			this.newNews = new News();
		}

		public Builder withId(Integer id) {
			newNews.setId(id);
			return this;
		}

		public Builder withTitle(String title) {
			newNews.setTitle(title);
			return this;
		}

		public Builder withBrief(String brief) {
			newNews.setBrief(brief);
			return this;
		}

		public Builder withContent(String content) {
			newNews.setContent(content);
			return this;
		}

		public Builder withDate(LocalDate date) {
			newNews.setDate(date);
			return this;
		}

		public Builder withAuthor(User author) {
			newNews.setAuthor(author);
			return this;
		}

		public News build() {
			return newNews;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        News that = (News) obj;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(brief, that.brief) && Objects.equals(content, that.content) 
        		&& Objects.equals(date, that.date) && Objects.equals(author, that.author);
    }
	
	@Override
	public int hashCode() {
    	int result = (int) (id ^ (id >>> 32));
    	result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);		
		result = 31 * result + (author == null ? 0 : author.hashCode());
		return result;
	}

	@Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author.toString() + '\'' +
                '}';
    }	
}