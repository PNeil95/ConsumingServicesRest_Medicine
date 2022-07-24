package com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.api
import com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.entidad.Medicamento
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
interface ApiService {
    @POST("/medicamento/registrar")
    fun saveAuto(@Body bean:Medicamento): Call<Void>
    @GET("/medicamento/buscar/{codigo}")
    fun findAuto(@Path("codigo") cod:Int): Call<Medicamento>
}