package com.example.fkapp.ui.china;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.fkapp.utils.SendGetThread;
import com.example.fkapp.utils.china.ChinaEpidemic;
import org.json.JSONException;

import java.io.IOException;

public class ChinaViewModel extends ViewModel {

    private MutableLiveData<ChinaEpidemic> chinaEpidemicMutableLiveData;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ChinaViewModel() throws InterruptedException, IOException, JSONException {
    }
}