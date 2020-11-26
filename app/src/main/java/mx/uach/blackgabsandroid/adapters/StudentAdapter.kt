package mx.uach.blackgabsandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.uach.blackgabsandroid.R
import mx.uach.blackgabsandroid.models.Student


class StudentAdapter(val students : List<Student>) : RecyclerView.Adapter<StudentAdapter.ViewHolder>(){
    inner class ViewHolder(listItem : View) : RecyclerView.ViewHolder(listItem) {
        val name : TextView = itemView.findViewById(R.id.txtNombre)
        val apellido : TextView = itemView.findViewById(R.id.txtApellido)
        val matricula : TextView = itemView.findViewById(R.id.txtMatricula)


        //val tvlastname : TextView = itemView.findViewById(R.id.tvlastname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val studentsView = inflater.inflate(R.layout.item_student, parent, false)
        return ViewHolder(studentsView)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student : Student = students.get(position)
        holder.name.text = student.name
        holder.apellido.text = student.lastname
        holder.matricula.text = "329610"

        //holder.tvlastname.text = student.lastname

    }
}