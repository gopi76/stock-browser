package com.gopi.stocksbrowser

import android.app.Activity
import android.app.AlertDialog
import android.view.LayoutInflater
import com.gopi.stocksbrowser.R

class DialogHelper(private val activity: Activity) {

    private var dialog: AlertDialog? = null



    fun startLoadingdialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.loading, null))
        builder.setCancelable(true)

        dialog = builder.create()
        dialog?.show()
    }

    fun dismissdialog() {
        dialog?.dismiss()
    }
}
