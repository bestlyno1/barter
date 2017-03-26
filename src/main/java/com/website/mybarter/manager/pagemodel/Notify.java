package com.website.mybarter.manager.pagemodel;

import com.website.mybarter.manager.model.Tuser;

public class Notify {

	private String id;
	// 通知标题
	private String title;
	// 通知内容
	private String text;
	// 通知类型
	private String ntype;
	// 通知范围
	private String nscope;
	// 是否邮件通知
	private String sendmail;
	// 发布者
	private Tuser tuser;
	// 发布时间
	private String releasetime;
	// 有效期
	private String exprirydate;
	// 页数
	private int pages;
	// 行数
	private int rows;

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * @return the id
	 */
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
	 * @return the tuser
	 */
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
	 * @return the releasetime
	 */
	public String getReleasetime() {
		return releasetime;
	}

	/**
	 * @param releasetime
	 *            the releasetime to set
	 */
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}

	/**
	 * @return the exprirydate
	 */
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
