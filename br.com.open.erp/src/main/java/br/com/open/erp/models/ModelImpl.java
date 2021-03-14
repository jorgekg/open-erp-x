package br.com.open.erp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class ModelImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private Long companyId;
	
	@Column(nullable = false)
	private Date createdAt;
	
	@Column(nullable = false)
	private String createdBy;
	
	@Column(nullable = false)
	private Date updateAt;
	
	@Column(nullable = false)
	private String updateBy;
	
	@PrePersist
	private void onCreate() {
		createdAt = new Date();
		updateAt = new Date();
		
		createdBy = "System";
		updateBy = "System";
	}
	
	@PreUpdate
	private void onUpdate() {
		updateAt = new Date();
		updateBy = "System";
	}

}
