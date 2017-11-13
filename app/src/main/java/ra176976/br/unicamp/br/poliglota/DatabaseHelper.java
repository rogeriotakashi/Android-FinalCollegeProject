package ra176976.br.unicamp.br.poliglota;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by r176976 on 13/09/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Poliglota";
    private static final int DB_VERSION = 1;

    DatabaseHelper (Context context){
        super (context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Idiomas (" +
                "idIdioma INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "Idioma TEXT," +
                "Origem TEXT);");


        ContentValues contentValues = new ContentValues();
        contentValues.put("Idioma", "Português");
        contentValues.put("Origem", "http://4vector.com/i/free-vector-flag-of-portugal-clip-art_112020_Flag_Of_Portugal_clip_art_hight.png");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "Inglês");
        contentValues.put("Origem", "https://static.todamateria.com.br/upload/ba/nd/bandeira_americana_bb.jpg");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "Japonês");
        contentValues.put("Origem", "http://www.br.emb-japan.go.jp/cultura/bandeira.jpg");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "Alemão");
        contentValues.put("Origem", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/290px-Flag_of_Germany.svg.png");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "Frances");
        contentValues.put("Origem", "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1280px-Flag_of_France.svg.png");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "Espanhol");
        contentValues.put("Origem", "http://www.bandeirasnacionais.com/data/flags/ultra/es.png");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "Mandarim");
        contentValues.put("Origem", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/300px-Flag_of_the_People%27s_Republic_of_China.svg.png");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "Coreano");
        contentValues.put("Origem", "http://www.koreapost.com.br/wp-content/uploads/2015/03/bandeira-da-Coreia-do-Sul-1021x580.jpg");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "Russo");
        contentValues.put("Origem", "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/1200px-Flag_of_Russia.svg.png");
        sqLiteDatabase.insert("Idiomas", null, contentValues);

        contentValues.put("Idioma", "idioma Extra");
        contentValues.put("Origem", "https://cdn0.iconfinder.com/data/icons/flat-security-icons/512/plus-blue.png");
        sqLiteDatabase.insert("Idiomas", null, contentValues);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
