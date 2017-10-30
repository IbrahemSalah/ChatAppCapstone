package com.google.firebase.udacity.friendlychat;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class ChatWidget extends AppWidgetProvider {


    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                       int[] appWidgetId, MessageAdapter mMessageAdapter) {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.chat__widget);

        if (views != null) {
            int messagesCount = mMessageAdapter.getCount();
            //Log.i("counter ", String.valueOf(messagesCount));
            views.setTextViewText(R.id.firstUser, mMessageAdapter.getItem(messagesCount - 1).getName());
            views.setTextViewText(R.id.firstUserText, mMessageAdapter.getItem(messagesCount - 1).getText());

            views.setTextViewText(R.id.secondUser, mMessageAdapter.getItem(messagesCount - 2).getName());
            views.setTextViewText(R.id.secondUserText, mMessageAdapter.getItem(messagesCount - 2).getText());
        }

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        views.setOnClickPendingIntent(R.id.WidgetLayout, pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            // updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }


}

