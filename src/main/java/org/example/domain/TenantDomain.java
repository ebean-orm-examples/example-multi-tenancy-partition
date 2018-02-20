package org.example.domain;

import io.ebean.annotation.TenantId;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TenantDomain extends BaseDomain {

	@TenantId
	String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}

