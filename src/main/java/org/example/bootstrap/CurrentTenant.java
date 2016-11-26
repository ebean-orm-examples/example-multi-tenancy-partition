package org.example.bootstrap;

import com.avaje.ebean.config.CurrentTenantProvider;

class CurrentTenant implements CurrentTenantProvider {

  /**
   * Return the current tenantId from the user context.
   */
  @Override
  public String currentId() {
    return UserContext.get().getTenantId();
  }
}
