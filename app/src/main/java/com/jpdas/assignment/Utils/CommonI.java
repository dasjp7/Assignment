package com.jpdas.assignment.Utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jpdas.assignment.ErrorPage;

public class CommonI
{
    public static boolean connectionAvailable(Context mContext) {
        ConnectivityManager
                cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }

    public static void redirectToErrorPage(final Context context, String errorText, String errorMessage, int errorType) {
        Intent errorIntent = new Intent(context, ErrorPage.class);
        switch (errorType) {
            case 0: //When --> there is no internet connection
                errorIntent.putExtra(Extras.CHECK_INTERNET, errorText);
                context.startActivity(errorIntent);
                break;
            case 1: //When --> there is Exception
                errorIntent.putExtra(Extras.SOMETHING_WENT_WRONG, errorText);
                errorIntent.putExtra(Extras.ERROR_MESSAGE_TEXT, errorMessage);
                context.startActivity(errorIntent);
                break;
            case 2: //When --> Failure in getting Response
                errorIntent.putExtra(Extras.SOMETHING_WENT_WRONG, errorText);
                errorIntent.putExtra(Extras.ERROR_MESSAGE_TEXT, errorMessage);
                context.startActivity(errorIntent);
                break;
            case 3: //When --> response.getString(JsonChilds.ISERROR).equals("1")
                errorIntent.putExtra(Extras.SOMETHING_WENT_WRONG, errorText);
                context.startActivity(errorIntent);
                break;
            case 4: //When --> there is Database Error
                errorIntent.putExtra(Extras.SOMETHING_WENT_WRONG, errorText);
                errorIntent.putExtra(Extras.ERROR_MESSAGE_TEXT, errorMessage);
                context.startActivity(errorIntent);
                break;
            default:
                break;

        }
    }
}
