package org.example.domain;

import org.example.domain.finder.ContentFinder;
import javax.persistence.Entity;

@Entity
public class Content extends TenantDomain {

  public static final ContentFinder find = new ContentFinder();

  String title;
  String byline;
  String body;

  public String toString() {
    return "id:" + id + " title:" + title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getByline() {
    return byline;
  }

  public void setByline(String byline) {
    this.byline = byline;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
