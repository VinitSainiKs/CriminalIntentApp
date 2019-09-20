package com.bignerdranch.android.criminalintent

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat

class CrimeAdapter(val crimes: List<Crime>) : RecyclerView.Adapter<CrimeAdapter.CrimeHolder>() {
    lateinit var context : Context
    val dateFormatter = SimpleDateFormat("EEE dd, yyyy")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_crime, parent, false)
        context = parent.context
        return CrimeHolder(view)
    }

    override fun getItemCount(): Int {
        return crimes.size
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.itemView.findViewById<TextView>(R.id.crime_title).text = crime.title
        holder.itemView.findViewById<TextView>(R.id.crime_date).text = dateFormatter.format(crime.date)
        holder.itemView.findViewById<ImageView>(R.id.crime_solved).visibility = if(crime.isSolved){
            View.VISIBLE
        }else{
            View.GONE
        }
        holder.itemView.findViewById<CardView>(R.id.item_card).setOnClickListener {
            Toast.makeText(context, "${crime.title}", Toast.LENGTH_SHORT).show()
        }
    }


    class CrimeHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}