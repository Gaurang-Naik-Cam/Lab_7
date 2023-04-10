package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_settings -> { Toast.makeText(this,"Settings are selected",Toast.LENGTH_SHORT).show() }
            R.id.nav_about -> {
               var infoMessage = " Developer Info:\r\n Name: Gaurang Naik \r\n Student # A00250808 \r\n Course Name: JAV-1001 App Development for Android"
                Toast.makeText(this,infoMessage,Toast.LENGTH_LONG).show() }

        }



        return super.onOptionsItemSelected(item)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adding a common adapter to both team1 and team 2 spinner class
        val spinnerMavericks: Spinner = findViewById(R.id.spinnerTeam1)
        val spinnerWarriors: Spinner = findViewById(R.id.spinnerTeam2)
        ArrayAdapter.createFromResource(
            this,
            R.array.scores_array,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerMavericks.adapter = adapter
            spinnerWarriors.adapter = adapter
        }
    }

    //This is event handler for awarding the points to Team1
    fun incrementScoreTeam1(view: android.view.View) {
        val spinnerMavericks: Spinner = findViewById(R.id.spinnerTeam1);
        var selectedItem = spinnerMavericks.selectedItem
        if (selectedItem.equals("Select Points")) { // sending short Toast message as a validation if user has not selected the Points from Spinner
            Toast.makeText(
                applicationContext, "Please select the points to be awarded from the dropdown.",
                Toast.LENGTH_SHORT
            ).show();
        } else {
            val textViewScore: TextView = findViewById(R.id.textViewScoreTeam1);
            val incrementBy: Int = selectedItem.toString().toInt();
            val currentScore: Int = textViewScore.text.toString().toInt();
            textViewScore.text = (incrementBy + currentScore).toString(); // Incrementing the points and assigning it to our textViewScore view to show updated points.
        }
    }

    //This is event handler for reducing the points to Team1
    fun decrementScoreTeam1(view: android.view.View) {
        val spinnerMavericks: Spinner = findViewById(R.id.spinnerTeam1);
        var selectedItem = spinnerMavericks.selectedItem
        if (selectedItem.equals("Select Points")) { // sending short Toast message as a validation if user has not selected the Points from Spinner
            Toast.makeText(
                applicationContext, "Please select the points to be reduced from the dropdown.",
                Toast.LENGTH_SHORT
            ).show();
        } else {
            val textViewScore: TextView = findViewById(R.id.textViewScoreTeam1);
            val decrementBy: Int = selectedItem.toString().toInt();
            val currentScore: Int = textViewScore.text.toString().toInt();
            if (currentScore != 0) { // points cannot be lesser than 0. Added a validation
                textViewScore.text = (currentScore - decrementBy).toString(); // Decrementing the points and assigning it to our textViewScore view to show updated points.
            } else { // sending short toast message if user attempts to reduce more than 0.
                Toast.makeText(
                    applicationContext, "Can not reduce beyond zero.",
                    Toast.LENGTH_SHORT
                ).show();
            }
        }
    }

    //This is event handler for awarding the points to Team2
    fun incrementScoreTeam2(view: android.view.View) {
        val spinnerWarriors: Spinner = findViewById(R.id.spinnerTeam2);
        var selectedItem = spinnerWarriors.selectedItem
        if (selectedItem.equals("Select Points")) { // sending short Toast message as a validation if user has not selected the Points from Spinner
            Toast.makeText(
                applicationContext, "Please select the points to be awarded from the dropdown.",
                Toast.LENGTH_SHORT
            ).show();
        } else {
            val textViewScore: TextView = findViewById(R.id.textViewScoreTeam2);
            val incrementBy: Int = selectedItem.toString().toInt();
            val currentScore: Int = textViewScore.text.toString().toInt();
            textViewScore.text = (incrementBy + currentScore).toString(); // Incrementing the points and assigning it to our textViewScore view to show updated points.
        }
    }

    fun decrementScoreTeam2(view: android.view.View) {
        val spinnerWarriors: Spinner = findViewById(R.id.spinnerTeam2);
        var selectedItem = spinnerWarriors.selectedItem
        if (selectedItem.equals("Select Points")) {// sending short Toast message as a validation if user has not selected the Points from Spinner
            Toast.makeText(
                applicationContext, "Please select the points to be reduced from the dropdown.",
                Toast.LENGTH_SHORT
            ).show();
        } else {
            val textViewScore: TextView = findViewById(R.id.textViewScoreTeam2);
            val decrementBy: Int = selectedItem.toString().toInt();
            val currentScore: Int = textViewScore.text.toString().toInt();
            if (currentScore != 0) { // points cannot be lesser than 0. Added a validation
                textViewScore.text = (currentScore - decrementBy).toString(); // Decrementing the points and assigning it to our textViewScore view to show updated points.
            } else { // sending short toast message if user attempts to reduce more than 0.
                Toast.makeText(
                    applicationContext, "Can not reduce beyond zero.",
                    Toast.LENGTH_SHORT
                ).show();
            }
        }

    }
}
