package com.example.todotaskapp.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.evernote.android.job.DailyJob;
import com.evernote.android.job.JobRequest;
import com.example.App;
import com.example.todotaskapp.MainActivity;
import com.example.todotaskapp.R;
import com.example.todotaskapp.common.DateUtils;
import com.example.todotaskapp.todolist.source.Task;
import com.example.todotaskapp.todolist.source.TaskLocalSource;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class NotificationJob extends DailyJob {

    static final String TAG = "NotificationJob";
    private static final String CHANNEL_ID = "channel_01";

    public static void schedule() {
        // schedule between 7 and 8 AM
        DailyJob.schedule(new JobRequest.Builder(TAG), TimeUnit.HOURS.toMillis(7), TimeUnit.HOURS.toMillis(8));
    }

    public static void runNow() {
        DailyJob.startNowOnce(new JobRequest.Builder(TAG));

    }

    @NonNull
    @Override
    protected DailyJobResult onRunDailyJob(Params params) {


        TaskLocalSource source = new TaskLocalSource(App.getInstance());
        List<Task> overDueTasks = source.getOverDueTasks();
        for (int i = 0; i < overDueTasks.size(); i++) {
            Task overdueTask = overDueTasks.get(i);
            String title;
            title = String.format("%s", overdueTask.getDateTime());

            try {
                Date date = DateUtils.getDate(overdueTask.getDateTime());

                title =
                        android.text.format.DateUtils.getRelativeTimeSpanString(date.getTime(), System.currentTimeMillis(),
                                android.text.format.DateUtils.MINUTE_IN_MILLIS).toString();

            } catch (ParseException e) {
                e.printStackTrace();
            }

            String message = String.format("%s in %s", overdueTask.getTitle(), overdueTask.getProjectName());
            sendNotification(i, title, message);
        }


        return DailyJobResult.SUCCESS;
    }


    /**
     * Posts a notification in the notification bar when a transition is detected.
     * If the user clicks the notification, control goes to the MainActivity.
     */
    private void sendNotification(int id, String title, String text) {
        // Get an instance of the Notification manager
        NotificationManager mNotificationManager =
                (NotificationManager) App.getInstance().getSystemService(Context.NOTIFICATION_SERVICE);

        // Android O requires a Notification Channel.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = App.getInstance().getString(R.string.app_name);
            // Create the channel for the notification
            NotificationChannel mChannel =
                    new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);

            // Set the Notification Channel for the Notification Manager.
            mNotificationManager.createNotificationChannel(mChannel);
        }

        // Create an explicit content Intent that starts the main Activity.
        Intent notificationIntent = new Intent(App.getInstance(), MainActivity.class);

        // Construct a task stack.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(App.getInstance().getApplicationContext());

        // Add the main Activity to the task stack as the parent.
        stackBuilder.addParentStack(MainActivity.class);

        // Push the content Intent onto the stack.
        stackBuilder.addNextIntent(notificationIntent);

        // Get a PendingIntent containing the entire back stack.
        PendingIntent notificationPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // Get a notification builder that's compatible with platform versions >= 4
        NotificationCompat.Builder builder = new NotificationCompat.Builder(App.getInstance().getApplicationContext(), CHANNEL_ID);

        // Define the notification settings.
        builder.setSmallIcon(R.drawable.splash_logo_todoapp)
                .setGroup("Overdue")
                .setColor(Color.RED)
                .setContentTitle(title)
                .setContentText(text)
                .setContentIntent(notificationPendingIntent);

        // Set the Channel ID for Android O.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID); // Channel ID
        }

        // Dismiss notification once the user touches it.
        builder.setAutoCancel(true);

        // Issue the notification
        mNotificationManager.notify(id, builder.build());
    }

}