package com.example.riotapi.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.riotapi.model.PlayerResponse;
import com.example.riotapi.repository.PlayerRespository;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PlayerViewModel extends AndroidViewModel {
    private MutableLiveData<PlayerResponse> playerResponseMutableLiveData = new MutableLiveData<>();
    public LiveData<PlayerResponse> playerResponseLiveData = playerResponseMutableLiveData;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Boolean> booleanMutableLiveData = new MutableLiveData<>();
    public LiveData<Boolean> booleanLiveData = booleanMutableLiveData;
    private PlayerRespository playerRespository = new PlayerRespository();

    public void getPlayerFull(String playerName, String apikey){
        compositeDisposable.add(
                playerRespository.playerResponseSingle(playerName, apikey)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> booleanMutableLiveData.setValue(true))
                        .doAfterTerminate(() -> booleanMutableLiveData.setValue(false))
                        .subscribe(playerResponse -> playerResponseMutableLiveData.setValue(playerResponse),
                        throwable -> Log.i("LOG", "MESSAGE --> " + throwable.getMessage()))
        );
    }


    public PlayerViewModel(@NonNull Application application) {
        super(application);
    }
}
