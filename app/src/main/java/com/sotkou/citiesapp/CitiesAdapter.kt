package com.sotkou.citiesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CitiesAdapter(private val citiesList: ArrayList<City>):
    RecyclerView.Adapter<CitiesAdapter.MyViewHolder>() {
// Data source ειναι το citiesList μια ArrayList με αντικείμενα τύπου City
// Κληρονομούμε απο την κλάση RecyclerView.Adapter

        // Κρατά τις αναφορές για κάθε αντικείμενο της RecyclerView
    inner class MyViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView) {
        // Το itemView αναπαριστά το κάθε αντικείμενο στη λίστα
        var cityImage: ImageView
        var cityName: TextView
        init {
            cityImage = itemView.findViewById(R.id.imageCard)
            cityName = itemView.findViewById(R.id.textView)

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "${citiesList[adapterPosition].cityName} we are coming!",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // δημιουργεί και επιστρέφει ενα νέο viewHolder instance για κάθε
        // item στην λίστα.
        // Το parent ειναι το viewGroup που θα "κολλήσουμε" το νεο view
        // Το viewType χρησιμοποιείται οταν το recyclerView έχει πολλούς
        // τύπους item δίνοντας την δυνατότητα για πολλαπλά layouts για
        // τον κάθε τύπο.

        // LayoutInflater η κλάση που κάνει οντότητα ενα xml στο αντίστοιχο view αντικείμενο
        val view = LayoutInflater.from(parent.context)
            // Εμφανίζει ενα view απο το layout xml
            .inflate(R.layout.card_item_layout,
                parent,
                false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        // Επιστρέφει τον αριθμό των items στο dataset
        return citiesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Γεμίζουμε δεδομένα στα views σε συγκεκριμένη θέση
        holder.cityImage.setImageResource(citiesList[position].cityImage)
        holder.cityName.text = citiesList[position].cityName
    }
}