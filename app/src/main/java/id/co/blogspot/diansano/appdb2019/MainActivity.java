package id.co.blogspot.diansano.appdb2019;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAdapter db = new DBAdapter(this);
        db.open();
      /*  db.insertContact("Cak Lontong", "cl@gmail.com");*/
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void DisplayContact(Cursor c) {
        Toast.makeText(this, "id: " + c.getString(0) + "\n"
                + "Name: " + c.getString(1) + "\n" + "Email: " + c.getString(2),
                Toast.LENGTH_SHORT).show();
    }
}
