package org.example.bootstrap;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.TenantMode;

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
