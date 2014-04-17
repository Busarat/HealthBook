package app.android.healthbook3.db;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import app.android.healthbook3.entry.UserDBEntry;

public class UserDB {
	
	private UserDBHelper uhelper;
	private SQLiteDatabase db;
	
	public UserDB(Context context) {
		uhelper = new UserDBHelper(context);
		db = uhelper.getWritableDatabase();
	}
	
	//insert
	public long insert(String name, String surname, String gender, String bd, String bType,
						String height, String addr, String homeTel, String relativeTel) {
		ContentValues val = new ContentValues();
		val.put(UserDBHelper.TABLE_KEY_NAME, name);
		val.put(UserDBHelper.TABLE_KEY_SURNAME, surname);
		val.put(UserDBHelper.TABLE_KEY_GENDER, gender);
		val.put(UserDBHelper.TABLE_KEY_BIRTH, bd);//.toLocaleString()
		val.put(UserDBHelper.TABLE_KEY_BLOODTYPE, bType);
		val.put(UserDBHelper.TABLE_KEY_HEIGHT, height);
		val.put(UserDBHelper.TABLE_KEY_ADDRESS, addr);
		val.put(UserDBHelper.TABLE_KEY_HOMETEL, homeTel);
		val.put(UserDBHelper.TABLE_KEY_RELATIVETEL, relativeTel);
		
//		Toast.makeText(null, "Saved", Toast.LENGTH_SHORT).show();
		return db.insert(UserDBHelper.TABLE_NAME, null, val);
	}
	
	//select lasted record
	public UserDBEntry select() {
		Cursor cursor = db.rawQuery("SELECT * FROM " + UserDBHelper.TABLE_NAME 
													+ " ORDER BY " 
													+ UserDBHelper.TABLE_KEY_USERID
													+ " DESC LIMIT 1", null);
		cursor.moveToFirst();

		UserDBEntry entry = null;
		if(cursor.getCount() != 0) {
			entry = new UserDBEntry();
			entry.setUid(cursor.getInt(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_USERID)));
			entry.setName(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_NAME)));
			entry.setSurname(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_SURNAME)));
			entry.setGender(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_GENDER)));
			entry.setBd(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_BIRTH)));
			entry.setBtype(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_BLOODTYPE)));
			entry.setHeight(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_HEIGHT)));
			entry.setAddr(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_ADDRESS)));
			entry.setHometel(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_HOMETEL)));
			entry.setRelativetel(cursor.getString(cursor.getColumnIndex(UserDBHelper.TABLE_KEY_RELATIVETEL)));
		}
		return entry;
	}
	
	//update or edit*****
	
	
	//delete by id

}
