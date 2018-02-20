package org.example.domain.finder;

import io.ebean.Finder;
import org.example.domain.OtherContent;

public class OtherContentFinder extends Finder<Long,OtherContent> {

  /**
   * Construct using the default EbeanServer.
   */
  public OtherContentFinder() {
    super(OtherContent.class);
  }

}
