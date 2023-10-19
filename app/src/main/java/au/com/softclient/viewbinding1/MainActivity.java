package au.com.softclient.viewbinding1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import au.com.softclient.viewbinding1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        //View view = mainBinding.getRoot();
        setContentView(mainBinding.getRoot());



        User myUser = new User("Mark",25, true);
        mainBinding.setUser(myUser);

        mainBinding.textView.setOnClickListener(v->{
            mainBinding.textView.setText("Clicked");
        });

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        //myViewModel.setMessage("I Am IronMan");
        //case-1
        //mainBinding.textView2.setText(myViewModel.getMessage().toString());

        //This Need if we applied LiveData object to the Data Binding
        //mainBinding.setViewModel(myViewModel);
        //mainBinding.setLifecycleOwner(this);


        // Set a different message with a 5s delay
        /*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myViewModel.setMessage("New message after 5s");
            }
        }, 5000);
        */

        myViewModel.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String message) {
                mainBinding.textView.setText(message);
                //Case-1
                mainBinding.textView2.setText(message);
            }
        });

        mainBinding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myViewModel.setMessage(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}