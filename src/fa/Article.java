package fa;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
    private long id;

	private Date updated;
	private String content;
	private String head;
	
	public Article() {
		
	}
	
	public Article(Date updated, String content, String head) {
		this.setUpdated(updated);
		this.setContent(content);
		this.setHead(head);
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
}
