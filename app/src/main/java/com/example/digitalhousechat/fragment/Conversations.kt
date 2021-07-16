package com.example.digitalhousechat.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalhousechat.activity.StudentAdapter
import com.example.digitalhousechat.databinding.FragmentConversationsBinding
import com.example.digitalhousechat.model.Student
import com.example.digitalhousechat.model.Title

class Conversations : Fragment() {
    private var binding: FragmentConversationsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConversationsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val students = listOf(
            Title("Alunos"),
            Student("Jéssica Milena", "Mobile Android", true),
            Student("Fábio Tadashi", "Mobile Android", true),
            Student("Guilherme Startori", "Mobile Android", true),
            Student("Kauan Valverde", "Mobile Android"),
            Student("Maiara Gusmão", "Mobile Android"),
            Student("Martin Afonso", "Mobile Android"),
            Student("Laysla Câmara", "Mobile Android"),
            Student("Lopo Frazão", "Mobile Android"),
            Student("Kendrick Bastos", "Mobile Android"),
            Student("Yi Ilha Marreiro", "Mobile Android"),
            Student("Fabiana Leão", "Mobile Android"),
            Student("Julieta Mont'Alverne", "Mobile Android")
        )

        val studentItemAdater = StudentAdapter(students) {
            Toast.makeText(context, "${it.name}", Toast.LENGTH_SHORT).show()
        }

        binding?.let {
            with(it) {
                vgStudentsRecyclerView.layoutManager = LinearLayoutManager(context)
                vgStudentsRecyclerView.adapter = studentItemAdater
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}