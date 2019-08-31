package com.josenobre.expensestracker.utils

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.UUID
import javax.inject.Inject

class FileManager @Inject constructor() {

    fun getOutputMediaFile(context: Context): Uri? {
        val mediaStorageDir = File(Environment.getExternalStorageDirectory(), "")

        if (!mediaStorageDir.exists())
            if (!mediaStorageDir.mkdirs())
                return null

        return FileProvider.getUriForFile(
            context, "com.josenobre.entertainmentapp.file.provider",
            File("${mediaStorageDir.path}/${UUID.randomUUID()}.jpg")
        )
    }

    fun createPartFromFile(uri: Uri, name: String): MultipartBody.Part {
        File(Environment.getExternalStorageDirectory(), "${"ImageFolder"}/${uri.lastPathSegment}").let {
            // create RequestBody INSTANCE from file
            val requestFile = RequestBody.create(
                MediaType.parse("image/jpeg"), it
            )

            // MultipartBody.Part is used to send also the actual file name
            return MultipartBody.Part.createFormData(name, it.name, requestFile)
        }
    }

    /*override fun openGallery() {
        setupPermissionsHelper(vStepBar, PERMISSIONS_LIBRARY)
        permissionHelper?.requestAll {
            getOutputMediaFile()?.let {
                tempUri = it
                startActivityForResult(intentChooserPicture(getString(R.string.global_add_select_image)), RC_PICK_PICTURE)
            }
        }
    }*/

    /*override fun onImageSourceConfirmed() {
        tempUri = null
        setupPermissionsHelper(vStepBar, PERMISSIONS_CAMERA)
        permissionHelper?.requestAll {
            getOutputMediaFile()?.let {
                tempUri = it
                startActivityForResult(intentInstaCamera(it, mCurrentSide), RC_TAKE_PICTURE)
            }
        }
    }*/
}