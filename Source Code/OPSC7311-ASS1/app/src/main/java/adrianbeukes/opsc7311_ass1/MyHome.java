package adrianbeukes.opsc7311_ass1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home);
    }

    //calls about us activity
    public void btnAboutActivity(View v)
    {
        Intent newActivity = new Intent(this,MyAbout.class);
        startActivity(newActivity);
    }

    //calls play game activity
    public void btnPlaytActivity(View v)
    {
        Intent newActivity = new Intent(this,MyGame.class);
        startActivity(newActivity);
    }
}
