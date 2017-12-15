package adrianbeukes.opsc7311_ass1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_about);
    }

    //calls new activity
    public void btnBackActivity(View v)
    {
        Intent newActivity = new Intent(this,MyHome.class);
        startActivity(newActivity);
    }
}
