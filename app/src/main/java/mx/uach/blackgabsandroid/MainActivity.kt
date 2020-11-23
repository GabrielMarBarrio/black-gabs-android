package mx.uach.blackgabsandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response
import com.google.gson.Gson
import mx.uach.blackgabsandroid.adapters.StudentAdapter
import mx.uach.blackgabsandroid.models.Student
import mx.uach.blackgabsandroid.models.Team

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val queue = Volley.newRequestQueue(this)
        val url = "https://black-gabs.herokuapp.com/about.json"
        val recyclerView : RecyclerView = findViewById(R.id.rvstudents)

        val jsonRequest : StringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                Log.i("JSON", response.toString())
                val gson = Gson()
                val team : Team = gson.fromJson(response.toString(), Team::class.java)
                val students : List<Student> = team.equipo
                recyclerView.adapter = StudentAdapter(students)
                recyclerView.layoutManager = LinearLayoutManager(this)
            }, Response.ErrorListener { error ->
                Log.e("JSON", "Error en la peticion ${error.toString()}")
            })
        queue.add(jsonRequest)


    }
}