package org.example.domain;

import io.ebean.Ebean;
import org.example.bootstrap.UserContext;
import org.testng.annotations.Test;

import java.util.List;

public class ContentTest extends BaseTestCase {

  @Test
  public void insert() {

    UserContext.set("rob", "ten_1");

    Content bean = new Content();
    bean.setTitle("Testing 123");
    bean.setByline("Thinking about testing with databases");
    bean.setBody("Lots of interesting stuff to say here");
    bean.save();

    bean.setTenantId("asdd");
    bean.setByline("Jimmy");
    bean.save();

    UserContext.set("roger", "ten_1");

    bean = new Content();
    bean.setTitle("Testing integration");
    bean.setByline("More testing databases");
    bean.setBody("Meh");
    bean.save();

    bean.delete();

    UserContext.set("fi", "ten_2");

    Content beanOther = new Content();
    beanOther.setTitle("Banana");
    beanOther.setByline("Yummy and yellow");
    beanOther.setBody("Food content");
    beanOther.save();


    UserContext.set("some", "ten_1");
    System.out.println("Tenant r1");
    findAll();

    UserContext.set("other", "ten_2");
    System.out.println("Tenant f1");
    findAll();

  }

  private void findAll() {

    System.out.println("find all (for the current tenant) " + UserContext.get().getTenantId());

    List<Content> allForTenant =
        Ebean.find(Content.class)
            .findList();

    for (Content content : allForTenant) {
      System.out.println(content);
    }
  }
}