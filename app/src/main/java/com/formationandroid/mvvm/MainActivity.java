package com.formationandroid.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.formationandroid.mvvm.model.Item;
import com.formationandroid.mvvm.repository.MainRepository;
import com.formationandroid.mvvm.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity
{
    // ViewModel :
    private MainViewModel mainViewModel;
    private TextView monTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monTextView = findViewById(R.id.text_view);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.init(new MainRepository());
        mainViewModel.getLiveDataItem().observe(this, new Observer<Item>(){
            @Override
            public void onChanged(Item item)
            {
                monTextView.setText(item.libelle);
            }
        });
    }
    // Listener :
    public void clicBoutonExemple(View view)
    {
        mainViewModel.clicBoutonExemple();
    }
}

