package com.mytrain.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.mytrain.R;
import com.mytrain.bean.Contact;
import com.mytrain.dao.ContactDao;

public class MyContactActivity extends Activity implements OnItemClickListener{
	private int userId;
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		addContactList();
		//listview.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

	private ListView listview;
	private TextView tv_title;
	private ImageView img_back;
	private ImageView addContact;
	private SimpleAdapter adapter;
	private List<Contact> contactList;
	private List<Map<String, Object>> Itemlists = new ArrayList<Map<String, Object>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mycontact);
		tv_title = (TextView) findViewById(R.id.tv_title);
		img_back = (ImageView) findViewById(R.id.img_back);
		img_back.setVisibility(View.VISIBLE);
		addContact = (ImageView) findViewById(R.id.addContact);
		addContact.setVisibility(View.VISIBLE);
		tv_title.setText("我的联系人");
		img_back.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
				finish();
				overridePendingTransition(R.anim.in_from_left,
						R.anim.out_to_right);
			}
		});
		SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
		userId = sp.getInt("userId", 0);
		initContact();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		addContact.setVisibility(View.INVISIBLE);
		super.onDestroy();
	}

	public void initContact() {
		listview = (ListView) findViewById(R.id.lv_contact);
		setContactLists();
		adapter = new SimpleAdapter(this, Itemlists, R.layout.item_contact,
				new String[] { "name", "cardId" }, new int[] { R.id.tv_name,
						R.id.tv_cardId });
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(this);
		addContact.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MyContactActivity.this,
						AddContactActivity.class);
				startActivity(intent);
			}
		});
	}
	
	public void setContactLists(){
		ContactDao cd = new ContactDao(this);	
		contactList = cd
				.selectContact("uId = ?",
						new String[] { String.valueOf(userId) }, null, null,
						null, null);
		for (int i = 0; i < contactList.size(); i++) {
			Map<String, Object> Itemlist = new HashMap<String, Object>();
			Contact contact = contactList.get(i);
			Itemlist.put("name", contact.getName());
			Itemlist.put("cardId", contact.getCardId());
			Itemlists.add(Itemlist);
		}
	}
	
	public void addContactList(){
		ContactDao cd = new ContactDao(this);	
		contactList = cd
				.selectContact("uId = ?",
						new String[] { String.valueOf(userId) }, null, null,
						"cId desc", null);
		Contact contact = contactList.get(0);
		Map<String, Object> Itemlist = new HashMap<String, Object>();;
		Itemlist.put("name", contact.getName());
		Itemlist.put("cardId", contact.getCardId());
		Itemlists.add(Itemlist);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = getIntent();
		intent.putExtra("isturntopage1", true);
		setResult(2,intent);
		finish();
	}

}
