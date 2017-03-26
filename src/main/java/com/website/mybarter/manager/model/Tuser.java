package com.website.mybarter.manager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_USER", schema = "mybarter")
public class Tuser implements java.io.Serializable
{

	/**
	 * user table
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String pwd;
	private Date createdatetime;
	private Date modifydatetime;

	public Tuser()
	{

	}

	public Tuser(String id, String name, String pwd)
	{
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	/** full constructor */
	public Tuser(String id, String name, String pwd, Date createdatetime,
			Date modifydatetime)
	{
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@Column(name = "NAME", unique = true, nullable = false, length = 100)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "PWD", nullable = false, length = 32)
	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATETIME", length = 8)
	public Date getCreatedatetime()
	{
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime)
	{
		this.createdatetime = createdatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFYDATETIME", length = 8)
	public Date getModifydatetime()
	{
		return modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime)
	{
		this.modifydatetime = modifydatetime;
	}

}
