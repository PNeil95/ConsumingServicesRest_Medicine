package com.example.app_cl3_t5wn_valladaresbazalarpaoloneil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.api.ApiService
import com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.entidad.Medicamento
import com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.utils.ApiUtils
import com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.utils.AppConfiguration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),View.OnClickListener{

    private lateinit var edtNombre:EditText
    private lateinit var edtStock:EditText
    private lateinit var edtPrecio:EditText
    private lateinit var btnGrabar:Button
    private lateinit var btnConsulta:Button
    private lateinit var api:ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtNombre=findViewById(R.id.edtNombre)
        edtStock=findViewById(R.id.edtStock)
        edtPrecio=findViewById(R.id.edtPrecio)
        btnGrabar=findViewById(R.id.btnGrabar)
        btnConsulta=findViewById(R.id.btnConsulta)
        btnGrabar.setOnClickListener(this)
        btnConsulta.setOnClickListener(this)
        api=ApiUtils.getAPIService();
    }

    override fun onClick(v: View?) {
        if(v==btnGrabar){
            var nom=edtNombre.text.toString()
            var sto=edtStock.text.toString().toInt()
            var pre=edtPrecio.text.toString().toDouble()
            var a=Medicamento(0,nom,sto,pre)
            grabarMedicamento(a)
        }
        else{
            val intent= Intent(this,ConsultaActivity::class.java)
            startActivity(intent)
        }
    }

    fun grabarMedicamento(bean:Medicamento){
        api.saveAuto(bean).enqueue(object: Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                TODO("Not yet implemented")
            }
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(AppConfiguration.CONTEXT, "Se grabo correctamente", Toast.LENGTH_LONG).show()
            }
        })
    }
}