package com.example.digitalhousechat.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousechat.databinding.StudentItemBinding
import com.example.digitalhousechat.databinding.StudentTitleItemBinding
import com.example.digitalhousechat.model.Student
import com.example.digitalhousechat.model.Title

class StudentAdapter(
    private val studentsList: List<Any>,
    private val onClickListener: (student: Student) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == VIEW_TYPE_TITLE) {
            val binding = StudentTitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolderTitle(binding)
        } else {
            val binding = StudentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder) {
            holder?.bind(studentsList[position] as Student, onClickListener)
        } else if(holder is ViewHolderTitle) {
            holder?.bind(studentsList[position] as Title)
        }
    }

    override fun getItemCount(): Int = studentsList.size

    override fun getItemViewType(position: Int): Int {
        return if(studentsList[position] is Title) {
            VIEW_TYPE_TITLE
        } else {
            VIEW_TYPE_DEFAULT
        }
    }

    class ViewHolder(val binding: StudentItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(
            student: Student,
            onClickListener: (student: Student) -> Unit
        ) {
            if(student.read) binding.ivStatus.visibility = View.VISIBLE
            binding.tvName.text = student.name
            binding.tvCourse.text = student.course
            binding.mcStudentItem.setOnClickListener {
                onClickListener(student)
                binding.ivStatus.visibility = View.INVISIBLE
                student.read = false
            }
        }
    }

    class ViewHolderTitle(val binding: StudentTitleItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(
            title: Title
        ) {
            binding.tvCategTitle.text = title.title
        }
    }

    companion object {
        const val VIEW_TYPE_DEFAULT = 1
        const val VIEW_TYPE_TITLE = 2
    }
}