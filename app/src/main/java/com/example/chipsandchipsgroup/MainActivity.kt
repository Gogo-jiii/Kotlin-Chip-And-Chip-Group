package com.example.chipsandchipsgroup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val multipleCheckedFilterChips = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defaultChip.setOnClickListener(this)
        chipChoice.setOnClickListener(this)
        chipAction.setOnClickListener(this)
        chipFilter.setOnClickListener(this)
        chipEntry.setOnClickListener(this)
        chip1EntryChip.setOnClickListener(this)
        chip2EntryChip.setOnClickListener(this)
        chip3EntryChip.setOnClickListener(this)

        chip1EntryChip.setOnCloseIconClickListener { v: View? ->
            chipGroupEntry.removeView(
                v
            )
        }
        chip2EntryChip.setOnCloseIconClickListener { v: View? ->
            chipGroupEntry.removeView(
                v
            )
        }
        chip3EntryChip.setOnCloseIconClickListener { v: View? ->
            chipGroupEntry.removeView(
                v
            )
        }
        chipEntry.setOnCloseIconClickListener {
            Toast.makeText(
                this@MainActivity, "closed",
                Toast.LENGTH_SHORT
            ).show()
        }

        chipGroupChoice.setOnCheckedStateChangeListener { group, checkedIds ->

            val chip = group.findViewById<Chip>(checkedIds[0])
            if (chip != null) {
                Toast.makeText(
                    this@MainActivity, "Choice Chip: " + chip.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        chipGroupEntry.setOnCheckedStateChangeListener { group, checkedIds ->

                val chip = group.findViewById<Chip>(checkedIds[0])
                if (chip != null) {
                    Toast.makeText(
                        this@MainActivity, "Entry Chip: " + chip.text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }

        getMultipleCheckedFilterChips()
    }

    private fun getMultipleCheckedFilterChips() {
        for (i in 0 until chipGroupFilter!!.childCount) {
            val chip = chipGroupFilter!!.getChildAt(i) as Chip
            chip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    multipleCheckedFilterChips.add(buttonView.text.toString())
                } else {
                    multipleCheckedFilterChips.remove(buttonView.text.toString())
                }
                if (multipleCheckedFilterChips.isNotEmpty()) {
                    Toast.makeText(
                        this@MainActivity, multipleCheckedFilterChips.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.defaultChip -> Toast.makeText(this, "clicked chip", Toast.LENGTH_SHORT).show()
            R.id.chipEntry -> Toast.makeText(this, "clicked entry chip", Toast.LENGTH_SHORT).show()
            R.id.chipChoice -> Toast.makeText(this, "clicked choice chip", Toast.LENGTH_SHORT)
                .show()
            R.id.chipAction -> Toast.makeText(this, "clicked action chip", Toast.LENGTH_SHORT)
                .show()
            R.id.chipFilter -> Toast.makeText(this, "clicked filter chip", Toast.LENGTH_SHORT)
                .show()
        }
    }
}