package kz.android.androidlab2.models

import com.google.gson.annotations.SerializedName

data class Figure(
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
    @SerializedName("info") val info: FigureInfo
)

data class FigureInfo(
    @SerializedName("born") val born: String = "",
    @SerializedName("died") val died: String = "",
    @SerializedName("years") val years: String = "",
    @SerializedName("office") val office: List<String> = emptyList(),
    @SerializedName("partners") val partners: String = "",
    @SerializedName("conflicts") val conflicts: List<String> = emptyList(),
    @SerializedName("notable_work") val notableWork: List<String> = emptyList(),
    @SerializedName("resting_place") val restingPlace: String = "",
    @SerializedName("cause_of_death") val causeOfDeath: String = "",
)