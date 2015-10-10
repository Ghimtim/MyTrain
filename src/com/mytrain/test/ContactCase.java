package com.mytrain.test;

import com.mytrain.bean.Contact;
import com.mytrain.bean.History;
import com.mytrain.dao.ContactDao;
import com.mytrain.dao.HistoryDao;
import com.mytrain.utils.DatabaseHelper;

import android.test.AndroidTestCase;

public class ContactCase extends AndroidTestCase {
	public void testCreate() {
		DatabaseHelper dbhelper = new DatabaseHelper(this.getContext());
		dbhelper.getWritableDatabase();
	}

	public void testSave() {
		ContactDao cdao = new ContactDao(this.getContext());
		Contact contact = new Contact();
		contact.setName("刘晓锋");
		contact.setUserId(1);
		contact.setCardId("456123199411110000");
		cdao.addContact(contact);
		contact.setName("廖锦天");
		contact.setUserId(1);
		contact.setCardId("412563199402296721");
		cdao.addContact(contact);
		contact.setName("庄智植");
		contact.setUserId(1);
		contact.setCardId("440234199401012233");
		cdao.addContact(contact);
	}
}
