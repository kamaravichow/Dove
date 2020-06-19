package io.github.kamaravichow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import io.github.dove.Dove;
import io.github.dove.DoveToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void makeAndroidDefualtToast(View view){
       Toast.makeText(view.getContext(), "Defualt Android Toast", Toast.LENGTH_LONG).show();
    }
    public void makeDefualtDoveToast(View view){
        DoveToast.makeText(view.getContext(),"This is a Dove DefaultToast", Dove.DOVE_LENGTH_LONG);
    }

    public void customDoveToast(View view){
        DoveToast.makeText(view.getContext(), "This is custom Dove Toast", R.mipmap.ic_launcher, Dove.DOVE_LENGTH_SHORT).setBackgroundColor(Color.RED).show();
    }

    private void method(){
        DoveToast toast = new DoveToast(this) // Make a dove toast object
                .setMessage("Message");
        toast.setIcon(R.mipmap.ic_launcher); // set values later
        toast.show(); // call to show
    }

}
