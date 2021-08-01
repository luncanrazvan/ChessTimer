package com.mindorks.framework.chess_timer.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.mindorks.framework.chess_timer.R
import com.mindorks.framework.chess_timer.uitls.SetTimerDialogFragmentListener
import kotlinx.android.synthetic.main.set_timer_layout.view.*

class SetTimerDialogFragment : DialogFragment() {

    private var timerValue: Long = 600000L

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            val view = inflater.inflate(R.layout.set_timer_layout, null)

            setUpDialog(view)
            builder.setTitle("Select a time for each player")
                    .setView(view)
            dialog?.setCanceledOnTouchOutside(false)
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun setUpDialog(view: View){
        view.timerValuePicker.minValue = 0
        view.timerValuePicker.maxValue = 3

        val timerPickerValues = arrayOf("10 minutes", "15 minutes", "30 minutes", "60 minutes")
        view.timerValuePicker.displayedValues = timerPickerValues
        view.timerValuePicker.setOnValueChangedListener { numberPicker: NumberPicker, _: Int, _: Int ->
            when(numberPicker.value){
                0 -> timerValue = 600000
                1 -> timerValue = 900000
                2 -> timerValue = 1800000
                3 -> timerValue = 3600000
            }

            Log.i("Timer", "Timer set at value $timerValue")
        }

        view.confirmButton.setOnClickListener{
            Log.i("Sending value", "$timerValue")
            (this.activity as? SetTimerDialogFragmentListener)?.onReturnValue(timerValue)
            Log.i("SetTimerDialogFragment", "Dismissed")
            this.dismiss()
        }
    }
}