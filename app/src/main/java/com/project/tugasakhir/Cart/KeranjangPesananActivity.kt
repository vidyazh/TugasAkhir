package com.project.tugasakhir.Cart

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.tugasakhir.R

class KeranjangPesananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang_pesanan)

        val radioGroup: RadioGroup = findViewById(R.id.metode_pembayaran)
        val transferBankOption: RadioButton = findViewById(R.id.radio_transfer_bank)
        val bankSpinner: Spinner = findViewById(R.id.spinner_bank)

        // Menambahkan listener untuk menangani padding sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menambahkan data ke Spinner
        val bankNames = arrayOf("Bank BNI", "Bank BCA", "Bank BRI", "Bank Mandiri")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bankNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bankSpinner.adapter = adapter

        // Menangani pilihan radio group
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radio_transfer_bank) {
                bankSpinner.visibility = View.VISIBLE
            } else {
                bankSpinner.visibility = View.GONE
            }
        }
    }
}