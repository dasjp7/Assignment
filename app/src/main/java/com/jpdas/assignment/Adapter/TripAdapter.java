package com.jpdas.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jpdas.assignment.R;
import com.jpdas.assignment.Models.Trip;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder>
{

    private Context mContext;
    private ArrayList<Trip> trips;



    public TripAdapter(Context mContext, ArrayList<Trip> trips) {
        this.mContext = mContext;
        this.trips = trips;
    }

    @NonNull
    @Override
    public TripAdapter.TripViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_trips, viewGroup, false);
        return new TripAdapter.TripViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final TripAdapter.TripViewHolder tripViewHolder, int position) {
        Trip currentItem = trips.get(position);
        tripViewHolder.from.setText(currentItem.getFrom());
        tripViewHolder.to.setText(currentItem.getTo());
        tripViewHolder.value.setText(String.valueOf(currentItem.getValue()));
        tripViewHolder.currency_symbol.setText(currentItem.getCurrency_symbol());

        int t = currentItem.getTrip_duration_min();

        int hours = t / 60;
        int minutes = t % 60;

        if(hours==0)
        {
            tripViewHolder.travel_time.setText("Travel time: "+String.valueOf(minutes)+"min");
        }
        else
            {
                tripViewHolder.travel_time.setText("Travel time: "+String.valueOf(hours)+"h "+String.valueOf(minutes)+"min");
            }


  //      long dateTimeValue = currentItem.getFrom_time();


        //convertTime(dateTimeValue);


        //tripViewHolder.from_time.setText(convertTime(dateTimeValue));



//        Date date=new Date(dateTimeValue);
//
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
//            SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
//            date = df2.parse("yourdate");
//        } catch (java.text.ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        //      tripViewHolder.from_time.setText(date.toString());







    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    public class TripViewHolder extends RecyclerView.ViewHolder {

        public TextView from, to,value,currency_symbol,travel_time,from_time,to_time;


        public TripViewHolder(@NonNull View itemView) {
            super(itemView);

            from = itemView.findViewById(R.id.tv_from);
            to = itemView.findViewById(R.id.tv_to);
            value = itemView.findViewById(R.id.tv_value);
            currency_symbol = itemView.findViewById(R.id.tv_currency_symbol);
            travel_time = itemView.findViewById(R.id.tv_time);
            from_time=itemView.findViewById(R.id.tv_from_time);

        }

    }


    public String convertTime(long time){

        String dateTimeInUsersFormat = null;

        ZoneId usersTimeZone = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            usersTimeZone = ZoneId.of("Asia/Tashkent");
        }
        Locale usersLocale = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            usersLocale = Locale.forLanguageTag("ga-IE");
        }
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                    .withLocale(usersLocale);
        }

        long microsSince1970 = time;
        long secondsSince1970 = TimeUnit.MICROSECONDS.toSeconds(microsSince1970);
        long remainingMicros = microsSince1970 - TimeUnit.SECONDS.toMicros(secondsSince1970);
        ZonedDateTime dateTime = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dateTime = Instant.ofEpochSecond(secondsSince1970,
                    TimeUnit.MICROSECONDS.toNanos(remainingMicros))
                    .atZone(usersTimeZone);
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             dateTimeInUsersFormat = dateTime.format(formatter);
        }

        return dateTimeInUsersFormat;
    }

}
