package com.burakkodaloglu.roomlibary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "kisiler")
data class Kisiler(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "kisi_id") val kisi_id:Int,
                   @ColumnInfo(name = "kisi_ad") val kisi_ad:String,
                   @ColumnInfo(name = "kisi_yas") val kisi_yas:Int)
{

}
