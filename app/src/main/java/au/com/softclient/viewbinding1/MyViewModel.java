package au.com.softclient.viewbinding1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> message = new MutableLiveData<>();

    public MyViewModel() {
        message.setValue("Constructor Initial");
    }

    public void setMessage(String textVal){
       message.setValue(textVal);
    }

    public LiveData<String> getMessage(){
        return message;
    }
}
