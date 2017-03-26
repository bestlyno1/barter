package com.website.mybarter.manager.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_NOTIFY", schema = "mybarter")
public class Tnotify {

	private String id;
	private String title;
	private String text;
	private String ntype;
	private String nscope;
	private String sendmail;
	private Tuser tuser;
	private Date releasetime;
	private String exprirydate;

	public Tnotify() {

	}

	public Tnotify(String id, String title, String text, String ntype, String nscope, 
			String sendmail, Tuser tuser, Date releasetime,
			String exprirydate) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.ntype = ntype;
		this.nscope = nscope;
		this.sendmail = sendmail;
		this.tuser = tuser;
		this.releasetime = releasetime;
		this.exprirydate = exprirydate;
	}

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	@Column(name = "title", length = 200)
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the text
	 */
	@Column(name = "text", length = 500)
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the ntype
	 */
	@Column(name = "ntype", length = 20)
	public String getNtype() {
		return ntype;
	}

	/**
	 * @param ntype
	 *            the ntype to set
	 */
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}

	/**
	 * @return the nscope
	 */
	@Column(name = "nscope", length = 200)
	public String getNscope() {
		return nscope;
	}

	/**
	 * @param nscope
	 *            the nscope to set
	 */
	public void setNscope(String nscope) {
		this.nscope = nscope;
	}

	/**
	 * @return the sendmail
	 */
	@Column(name = "sendmail", length = 1)
	public String getSendmail() {
		return sendmail;
	}

	/**
	 * @param sendmail
	 *            the sendmail to set
	 */
	public void setSendmail(String sendmail) {
		this.sendmail = sendmail;
	}

	/**
	 * @return the releasetime
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "releasetime", length = 8)
	public Date getReleasetime() {
		return releasetime;
	}

	/**
	 * @param releasetime
	 *            the releasetime to set
	 */
	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	/**
	 * @return the tuser
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "USER_ID")
	public Tuser getTuser() {
		return tuser;
	}

	/**
	 * @param tuser
	 *            the tuser to set
	 */
	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	/**
	 * @return the exprirydate
	 */
	@Column(name = "exprirydate", length = 2)
	public String getExprirydate() {
		return exprirydate;
	}

	/**
	 * @param exprirydate
	 *            the exprirydate to set
	 */
	public void setExprirydate(String exprirydate) {
		this.exprirydate = exprirydate;
	}

}
