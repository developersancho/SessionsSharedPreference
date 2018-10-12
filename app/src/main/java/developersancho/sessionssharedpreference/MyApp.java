package developersancho.sessionssharedpreference;

import android.app.Application;

import java.util.Timer;
import java.util.TimerTask;

public class MyApp extends Application {

    LogoutListener listener;
    Timer timer;

    /*public void touch() {
        ApplockManager.getInstance().enableDefaultAppLockIfAvailable(new MyApp());
        ApplockManager.getInstance().updateTouch();
    }*/


    public void startUserSession() {
        cancelTimer();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                listener.onSessionLogout();
            }
        }, 5000);
    }

    private void cancelTimer() {
        if (timer != null) timer.cancel();
    }

    public void registerSessionListener(LogoutListener listener) {
        this.listener = listener;
    }


    public void onUserInteracted() {
        startUserSession();
    }

}
