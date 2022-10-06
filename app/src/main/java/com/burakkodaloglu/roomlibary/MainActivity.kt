package com.burakkodaloglu.roomlibary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var vt: Veritabani
    private lateinit var kdao: KisilerDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vt = Veritabani.veritabaniErisim(this)!!
        kdao = vt.getKisilerDao()
        //guncelle()
        //ekle()
        //sil()
        //ara()
        //getir()
        kisileriYukle()
        //kontrol()
    }

    fun kisileriYukle() {
        val job = CoroutineScope(Dispatchers.IO).launch {
            val gelenListe = kdao.tumkisiler()

            for (k in gelenListe) {
                Log.e("Kişi id", k.kisi_id.toString())
                Log.e("Kişi ad", k.kisi_ad)
                Log.e("Kişi yaş", k.kisi_yas.toString())

            }
        }
    }

    //Yeni Kayıt
    fun ekle() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0, "Ahmet", 50)
            kdao.kisiEkle(yeniKisi)
        }
    }
    //Kayıt Güncelleme
    fun guncelle() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenKisi = Kisiler(3, "Ahmet", 50)
            kdao.kisiGuncelle(guncellenenKisi)
        }
    }
    //Kayıt Silme
    fun sil() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = Kisiler(3, "Ahmet", 50)
            kdao.kisiSil(silinenKisi)
        }
    }
    fun rastgele() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenListe = kdao.rastgele1kisiGetir()

            for (k in gelenListe) {
                Log.e("Kişi id", k.kisi_id.toString())
                Log.e("Kişi ad", k.kisi_ad)
                Log.e("Kişi yaş", k.kisi_yas.toString())

            }
        }
    }
    fun ara() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenListe = kdao.kisiArama("e")

            for (k in gelenListe) {
                Log.e("Kişi id", k.kisi_id.toString())
                Log.e("Kişi ad", k.kisi_ad)
                Log.e("Kişi yaş", k.kisi_yas.toString())

            }
        }
    }
    fun getir() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenKisi = kdao.kisiGetir(2)

                Log.e("Kişi id", gelenKisi.kisi_id.toString())
                Log.e("Kişi ad", gelenKisi.kisi_ad)
                Log.e("Kişi yaş", gelenKisi.kisi_yas.toString())

        }
    }
    fun kontrol() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val gelenSonuc = kdao.kayitKontrol("Ece")
            Log.e("Kişi kontrol", gelenSonuc.toString())
        }
    }
}