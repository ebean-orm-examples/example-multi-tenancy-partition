package org.example.domain;


import io.ebean.Ebean;
import org.example.bootstrap.UserContext;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OtherContentTest extends BaseTestCase {

	private static String[] names = {"Ace", "Base", "Case", "Dae", "Eva"};

	static void insertAccounts() {
		for (int i = 0; i < 5; i++) {
			new Account("ten_"+i, names[i]).save();
		}
	}

	static {
		insertAccounts();
	}

	@Test
	public void insertAndQuery() {

		UserContext.set("rob", "ten_1");

		Account account = Account.find.ref(UserContext.get().getTenantId());

		// explicitly set Account using a reference bean
		OtherContent content0 = new OtherContent(account, "Good title");
		content0.save();

		// automatically setting account (via CurrentTenant / UserContext)
		OtherContent content1 = new OtherContent("Autoset tenantId");
		content1.save();

		List<OtherContent> contents = OtherContent.find.all();
		assertThat(contents).hasSize(2);

		// and the benefit of have Account is that we can do
		// fetch joins like this to also fetch account name
		contents = OtherContent.find.query()
				.fetch("account", "name")
				.findList();

		assertThat(contents).hasSize(2);

		OtherContent one = contents.get(0);
		one.setTitle("mod foo");
		Ebean.save(one);

		//Ebean.deleteAll(OtherContent.class, Arrays.asList(content1.getId(), content0.getId()));
		Ebean.delete(OtherContent.class, content1.getId());
	}

}