package org.example.domain.finder;

import io.ebean.Finder;
import org.example.domain.Account;

public class AccountFinder extends Finder<String,Account> {

  /**
   * Construct using the default EbeanServer.
   */
  public AccountFinder() {
    super(Account.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public AccountFinder(String serverName) {
    super(Account.class, serverName);
  }
}
