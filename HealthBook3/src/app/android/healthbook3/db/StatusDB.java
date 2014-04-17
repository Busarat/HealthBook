package app.android.healthbook3.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class StatusDB {
	
	private StatusDBHelper shelper;
	private SQLiteDatabase db;
	
	public StatusDB(Context context) {
		shelper = new StatusDBHelper(context);
		db = shelper.getWritableDatabase();
	}

	//insert
	
	
	//select by type
	
	
	//delete by id
	
	
}
