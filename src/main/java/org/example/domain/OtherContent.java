package org.example.domain;

import io.ebean.annotation.TenantId;
import org.example.domain.finder.OtherContentFinder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OtherContent extends BaseDomain {

	public static final OtherContentFinder find = new OtherContentFinder();

	@TenantId
	@ManyToOne(optional = false)
	Account account;

	String title;

	String body;

	public OtherContent(Account account, String title) {
		this.account = account;
		this.title = title;
	}

	public OtherContent(String title) {
		this.title = title;
	}

	public Account getAccount() {
		return account;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
