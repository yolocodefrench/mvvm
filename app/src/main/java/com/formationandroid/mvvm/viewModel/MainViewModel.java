package com.formationandroid.mvvm.viewModel;

import com.formationandroid.mvvm.model.Item;
import com.formationandroid.mvvm.repository.MainRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel
{
    // Repository :
    private MainRepository mainRepository;
    // LiveData item :
    private MutableLiveData<Item> liveDataItem;
    // Initialisation :
    public void init(MainRepository mainRepository)
    {
    // vérification que l'initialisation n'a pas déjà été faite :
        if (liveDataItem != null)
        {
            return;
        }
    // initialisation et premier chargement :
        this.mainRepository = mainRepository;
        liveDataItem = new MutableLiveData<>();
    }
    // LiveData item :
    public LiveData<Item> getLiveDataItem()
    {
        return liveDataItem;
    }
    // Listener clic bouton exemple :
    public void clicBoutonExemple()
    {
        mainRepository.getLiveDataItem(liveDataItem);
    }
}
