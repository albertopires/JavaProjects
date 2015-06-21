package music.penguin.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name="tb_profile")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL,
	typing = JsonSerialize.Typing.STATIC)
public class Profile implements Serializable {
	
	private static final long serialVersionUID = -7889127565252398505L;
	
	private Long id;
	private String desc;
	
	public Profile() {}

	@Id
	@Column(name="id_profile")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}