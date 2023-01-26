package com.native_module_example1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class MyService extends Service {
    private String Chan_Id = "service";
    private String Not_Name = "Foreground service";

    public MyService() {
    }


    public static void StartTheService(Context context, String message) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("input", message);
        ContextCompat.startForegroundService(context, intent);
    }

    public static void StopTheService(Context context) {
        Intent intent = new Intent(context, MyService.class);
        context.stopService(intent);
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int flags) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        String input = intent.getStringExtra("input");
        createNotification();
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 5, intent, PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("New mail from ")
                .setContentText("subject")
                .setSmallIcon(R.drawable.ic_alaram)
//                .setLargeIcon(aBitmap)
                .build();

        startForeground(1, notification);

    }


    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed...", Toast.LENGTH_LONG).show();
    }


    private void createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel servicechannel = new NotificationChannel(Chan_Id, Not_Name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(servicechannel);
        }
    }


}