package com.example.tugaspertemuan6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import com.example.tugaspertemuan6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datePicker = findViewById<DatePicker>(R.id.Tanggal)
        val timePicker = findViewById<TimePicker>(R.id.Waktu)
        val button = findViewById<Button>(R.id.pesan)

        val spinner = findViewById<Spinner>(R.id.tujuan_keberangkatan)
        val spinnerItems = arrayOf("Jogja", "Semarang", "Surabaya", "Klaten", "Surakarta")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        button.setOnClickListener {
            val tahun = datePicker.year
            val bulan = datePicker.month + 1
            val hari = datePicker.dayOfMonth
            val tanggal = "$hari-$bulan-$tahun"

            val jam = timePicker.hour
            val menit = timePicker.minute
            val waktu = "$jam-$menit"

            val selectedItem = spinner.selectedItem.toString()
            val message = "Tiket tujuan $selectedItem pada tanggal $tanggal dan jam $waktu berhasil dipesan"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}