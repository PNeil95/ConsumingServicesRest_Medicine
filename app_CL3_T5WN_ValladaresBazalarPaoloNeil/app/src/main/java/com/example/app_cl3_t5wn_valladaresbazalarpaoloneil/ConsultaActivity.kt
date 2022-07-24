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

class ConsultaActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtCodigoB: EditText
    private lateinit var edtNombreB: EditText
    private lateinit var edtStockB:EditText
    private lateinit var edtPrecioB:EditText
    private lateinit var btnBuscar:Button
    private lateinit var btnVolver:Button
    private lateinit var api:ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)
        edtCodigoB=findViewById(R.id.edtCodigoB)
        edtNombreB=findViewById(R.id.edtNombreB)
        edtStockB=findViewById(R.id.edtStockB)
        edtPrecioB=findViewById(R.id.edtPrecioB)
        btnBuscar=findViewById(R.id.btnBuscar)
        btnVolver=findViewById(R.id.btnVolver)
        btnBuscar.setOnClickListener(this)
        btnVolver.setOnClickListener(this)
        api=ApiUtils.getAPIService();
    }

    override fun onClick(v: View?) {
        if(v==btnBuscar){
            buscarAuto(edtCodigoB.text.toString().toInt())
        }
        else{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun buscarAuto(cod:Int){
        api.findAuto(cod).enqueue(object: Callback<Medicamento> {
            override fun onFailure(call: Call<Medicamento>, t: Throwable) {
                TODO("Not yet implemented")
            }
            override fun onResponse(call: Call<Medicamento>, response: Response<Medicamento>) {
                if(response.isSuccessful){
                    Toast.makeText(AppConfiguration.CONTEXT, "Código correcto", Toast.LENGTH_LONG).show()
                    var bean=response.body()
                    edtNombreB.setText(bean!!.nombre)
                    edtStockB.setText(bean!!.stock.toString())
                    edtPrecioB.setText(bean!!.precio.toString())
                }
                else{
                    Toast.makeText(AppConfiguration.CONTEXT, "Código no existe", Toast.LENGTH_LONG).show()
                    edtCodigoB.setText("")
                    edtNombreB.setText("")
                    edtStockB.setText("")
                    edtPrecioB.setText("")
                }

            }
        })
    }

}