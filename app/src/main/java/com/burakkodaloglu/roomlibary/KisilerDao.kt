package com.burakkodaloglu.roomlibary

import androidx.room.*

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun tumkisiler():List<Kisiler>

    @Insert //kayıt yapma
    suspend fun kisiEkle(kisiler: Kisiler)

    @Update //kayıt güncelleme
    suspend fun kisiGuncelle(kisiler: Kisiler)

    @Delete
    suspend fun kisiSil(kisiler: Kisiler)

    @Query("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT 1")
    suspend fun rastgele1kisiGetir():List<Kisiler>

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%'")
    suspend fun kisiArama(aramaKelimesi:String):List<Kisiler>

    @Query("SELECT * FROM kisiler WHERE kisi_id=:kisi_id")
    suspend fun kisiGetir(kisi_id:Int):Kisiler

    @Query("SELECT count(*) FROM kisiler WHERE kisi_ad=:kisi_ad")
    suspend fun kayitKontrol(kisi_ad:String):Int
}