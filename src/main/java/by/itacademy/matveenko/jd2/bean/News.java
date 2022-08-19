package by.itacademy.matveenko.jd2.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String brief;
	private String content;
	private String date;
	//private Integer idReporter = 0;
	
	public News(){}

	public News(Integer id, String title, String brief, String content, String date) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
		//this.idReporter = idReporter;
	}
	
	public News(String title, String brief, String content, String date) {		
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	//public Integer getIdReporter() {
	//	return idReporter;
	//}

	//public void setIdReporter(Integer idReporter) {
	//	this.idReporter = idReporter;
	//}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        News that = (News) obj;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(brief, that.brief) && Objects.equals(content, that.content) 
        		&& Objects.equals(date, that.date);
    }
	
	@Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +                
                '}';
    }	
}