package org.example.bootstrap;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.config.TenantMode;

public class BootstrapEbean {

  private final ServerConfig config = new ServerConfig();

  public BootstrapEbean() {

    config.loadFromProperties();
    config.loadTestProperties();

    config.setTenantMode(TenantMode.PARTITION);
    config.setCurrentTenantProvider(new CurrentTenant());
  }

  public EbeanServer create() {
    return EbeanServerFactory.create(config);
  }
}
