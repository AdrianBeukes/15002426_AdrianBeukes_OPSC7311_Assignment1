package adrianbeukes.opsc7311_ass1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.Random;
import java.lang.Runnable;

public class MyGame extends AppCompatActivity
{

    //declarations
    Button btnSpin;
    ImageView image1, image2, image3;
    Random r;
    int img1,img2, img3;
    int Total = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign
        r = new Random();

        btnSpin = (Button) findViewById(R.id.btnSpin);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);

        btnSpin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //animate images for spin motion
                image1.setImageResource(R.drawable.anim_spin);
                final AnimationDrawable image1anim = (AnimationDrawable) image1.getDrawable();
                image1anim.start();

                image2.setImageResource(R.drawable.anim_spin);
                final AnimationDrawable image2anim = (AnimationDrawable) image2.getDrawable();
                image2anim.start();

                image3.setImageResource(R.drawable.anim_spin);
                final AnimationDrawable image3anim = (AnimationDrawable) image3.getDrawable();
                image3anim.start();

                //stop animation
                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        image1anim.stop();
                        image2anim.stop();
                        image3anim.stop();

                        setImages();
                        getScore();
                    }
                }, 500); //timer, each image was set to 100
            }
        });
    }

    //calls new activity
    public void btnBackActivity(View v)
    {
        Intent newActivity = new Intent(this,MyHome.class);
        startActivity(newActivity);
    }

    //method to set pictures in image box
    public void setImages()
    {
        //randoms image
        img1 = r.nextInt(7) + 1;
        img2 = r.nextInt(7) + 1;
        img3 = r.nextInt(7) + 1;

        //set image for 1st block
        switch (img1)
        {
            case 1:
                image1.setImageResource(R.drawable.car1);
                break;
            case 2:
                image1.setImageResource(R.drawable.car2);
                break;
            case 3:
                image1.setImageResource(R.drawable.car3);
                break;
            case 4:
                image1.setImageResource(R.drawable.car4);
                break;
            case 5:
                image1.setImageResource(R.drawable.car5);
                break;
            case 6:
                image1.setImageResource(R.drawable.car6);
                break;
            case 7:
                image1.setImageResource(R.drawable.car7);
                break;
        }

        //set image for 2nd block
        switch (img2)
        {
            case 1:
                image2.setImageResource(R.drawable.car1);
                break;
            case 2:
                image2.setImageResource(R.drawable.car2);
                break;
            case 3:
                image2.setImageResource(R.drawable.car3);
                break;
            case 4:
                image2.setImageResource(R.drawable.car4);
                break;
            case 5:
                image2.setImageResource(R.drawable.car5);
                break;
            case 6:
                image1.setImageResource(R.drawable.car6);
                break;
            case 7:
                image1.setImageResource(R.drawable.car7);
                break;
        }

        //set image for 3rd block
        switch (img3)
        {
            case 1:
                image3.setImageResource(R.drawable.car1);
                break;
            case 2:
                image3.setImageResource(R.drawable.car2);
                break;
            case 3:
                image3.setImageResource(R.drawable.car3);
                break;
            case 4:
                image3.setImageResource(R.drawable.car4);
                break;
            case 5:
                image3.setImageResource(R.drawable.car5);
                break;
            case 6:
                image1.setImageResource(R.drawable.car6);
                break;
            case 7:
                image1.setImageResource(R.drawable.car7);
                break;
        }
    }

    //method to display if user won or lost
    public void getScore()
    {
        //if all 3 images match
        if( img1 == img2 && img2 == img3)
        {
            Toast.makeText(this,"Jackpot!!!", Toast.LENGTH_SHORT).show();
            Total = Total + 300;
        }

        //if 2 images match
        else if( img1 == img2 || img2 == img3 || img1 == img3)
        {
            Toast.makeText(this,"Wow!!!", Toast.LENGTH_SHORT).show();
            Total = Total + 150;
        }

        //if none match
        else
        {
            Total = Total -50;
        }

        //method to update score
        displayScore();
    }

    //display and update score
    public void displayScore()
    {
        //sends back to home screen when score reaches 0
        if(Total == 0)
        {
            Toast.makeText(this,"Sorry you lost, thank you for playing", Toast.LENGTH_SHORT).show();
            finish();
        }
        TextView scoreView = (TextView) findViewById(R.id.txtScore);
        scoreView.setText("Score : " + Total);
    }
}
