package app.android.healthbook3.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StatusDBHelper extends SQLiteOpenHelper {
	
	public static int TABLE_VERSION = 1;
	public static String TABLE_NAME = "status";
	public static String TABLE_KEY_SID = "sid";
	public static String TABLE_KEY_TYPE = "type";
	public static String TABLE_KEY_DATE = "date";
	public static String TABLE_KEY_DATA = "data";
	
	public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
										"" + TABLE_KEY_SID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
										"" + TABLE_KEY_TYPE + " TEXT(15), " +
										"" + TABLE_KEY_DATE + " TEXT(15), " +
										"" + TABLE_KEY_DATA + " TEXT(20) " +
										")";
	

	public StatusDBHelper(Context context) {
		super(context, TABLE_NAME, null, TABLE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE " + TABLE_NAME);
		onCreate(db);
		Log.i("user DB helper", "Table upgrade from " + oldVersion + " to " + newVersion);
	}

}
