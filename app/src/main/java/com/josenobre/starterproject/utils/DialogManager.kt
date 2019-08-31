package com.josenobre.starterproject.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import javax.inject.Inject

class DialogManager @Inject constructor() {

    fun showAlertDialog(
        context: Context,
        title: String,
        message: String,
        positiveText: String,
        positiveAction: () -> Unit
    ) {
        AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveText) { _, _ -> positiveAction() }
            .show()
    }

    fun generateCustomDialog(
        context: Context,
        title: String?,
        message: String?,
        positive: String?,
        negative: String?,
        option: Boolean,
        optionListener: com.josenobre.starterproject.utils.DialogManager.OptionListener?
    ): android.app.AlertDialog {
        val builder = android.app.AlertDialog.Builder(context)
        builder.setMessage(message)
        builder.setTitle(title)
            .setPositiveButton(positive) { dialog, _ ->
                optionListener?.onConfirm()
                dialog.dismiss()
            }

        if (option) {
            builder.setNegativeButton(negative) { dialog, _ ->
                optionListener?.onCancel()
                dialog.dismiss()
            }
        }

        builder.setOnCancelListener {
            optionListener?.onCancel()
        }
        return builder.create()
    }

    interface OptionListener {

        fun onConfirm()
        fun onCancel()
    }
}