package com.josenobre.expensestracker.network.api.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.josenobre.expensestracker.network.model.Movie
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.util.ArrayList

@Parcelize
data class MovieResponse(
    var page: Int? = null,
    var results: @RawValue List<Movie> = ArrayList(),
    @SerializedName(value = "total_results") var totalResults: Int? = null,
    @SerializedName(value = "total_pages") var totalPages: Int? = null
) : Parcelable
