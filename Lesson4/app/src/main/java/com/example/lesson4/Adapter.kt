package com.example.lesson4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4.databinding.PersonListBinding


class Adapter(
    var personList: Array<Person>,
    private val clickCard: (Person) -> Unit,
    private val clickCardLike: (Person) -> Unit
) : RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): Holder {
        val binding = PersonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding, clickCard, clickCardLike)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val person = personList[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    inner class Holder internal constructor(
        private val binding: PersonListBinding,
        private val clickCard: (Person) -> Unit,
        private val clickCardLike: (Person) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) = binding.run {
            name.text = person.name
            image.setImageResource(person.images)
            gender.text = person.gender
            date.text = person.date
            description.text = person.description


            binding.cardId.setOnClickListener {
                clickCard.invoke(person)
            }

            binding.like.setOnClickListener {
                clickCardLike.invoke(person)
            }
        }
    }
}
