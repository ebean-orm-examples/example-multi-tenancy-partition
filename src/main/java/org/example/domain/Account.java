package org.example.domain;

import io.ebean.Model;
import io.ebean.annotation.Length;
import org.example.domain.finder.AccountFinder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Account extends Model {

	public static final AccountFinder find = new AccountFinder();

	@Id
	private final String id;

	private String name;

	@Length(500)
	private String notes;

	@Version
	private long version;

	public Account(String id) {
		this.id = id;
	}

	public Account(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
