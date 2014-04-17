package app.android.healthbook3.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDBHelper extends SQLiteOpenHelper{
	
	public static int TABLE_VERSION = 1;
	public static String TABLE_NAME = "user_info";

	public static String TABLE_KEY_USERID = "uid";
	public static String TABLE_KEY_NAME = "name";
	public static String TABLE_KEY_SURNAME = "surname";
	public static String TABLE_KEY_GENDER = "gender";
	public static String TABLE_KEY_BIRTH = "birth";
	public static String TABLE_KEY_BLOODTYPE = "Btype";
	public static String TABLE_KEY_HEIGHT = "height";
	public static String TABLE_KEY_ADDRESS = "addr";
	public static String TABLE_KEY_HOMETEL = "home_tel";
	public static String TABLE_KEY_RELATIVETEL = "relative_tel";
	public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
										"" + TABLE_KEY_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
										"" + TABLE_KEY_NAME + " TEXT(20), " +
										"" + TABLE_KEY_SURNAME + " TEXT(20), " +
										"" + TABLE_KEY_GENDER + " TEXT(8), " +
										"" + TABLE_KEY_BIRTH + " TEXT(20), " +
										"" + TABLE_KEY_BLOODTYPE + " TEXT(5), " +
										"" + TABLE_KEY_HEIGHT + " TEXT(10), " +
										"" + TABLE_KEY_ADDRESS + " TEXT(50), " +
										"" + TABLE_KEY_HOMETEL + " TEXT(15), " +
										"" + TABLE_KEY_RELATIVETEL + " TEXT(15) " +
										")";

	public UserDBHelper(Context context) {
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
