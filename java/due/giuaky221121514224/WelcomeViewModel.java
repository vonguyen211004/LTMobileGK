package due.giuaky221121514224;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WelcomeViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public WelcomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to the app!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
