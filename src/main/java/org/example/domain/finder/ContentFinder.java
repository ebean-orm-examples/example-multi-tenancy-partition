package org.example.domain.finder;

import io.ebean.Finder;
import org.example.domain.Content;

public class ContentFinder extends Finder<Long,Content> {

  /**
   * Construct using the default EbeanServer.
   */
  public ContentFinder() {
    super(Content.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public ContentFinder(String serverName) {
    super(Content.class, serverName);
  }
}
