package org.example.domain;

import javax.persistence.Entity;

@Entity
public class Content extends BaseDomain {

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
