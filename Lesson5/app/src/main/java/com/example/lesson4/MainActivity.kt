package com.example.lesson4

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import android.os.AsyncTask


class MainActivity : Activity() {


    private val verticalLinearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    private lateinit var binding: ActivityMainBinding
    private var mainPersonList: MutableList<Person> = mutableListOf()

    private var task: AddListItemsTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.personList.layoutManager = verticalLinearLayoutManager

        val pair = lastNonConfigurationInstance as Pair<List<Person>, AddListItemsTask?>?
        task = pair?.second
        mainPersonList = pair?.first?.toMutableList() ?: mutableListOf()
        if (task == null) {
            task = AddListItemsTask()
            task?.execute()
        }
        task?.link(this)
        binding.personList.adapter =
            Adapter(mainPersonList, ::showCard, ::showLike)
    }

    fun addData(person: Person) {
        mainPersonList.add(person)
        binding.personList.adapter?.notifyDataSetChanged()
    }

    override fun onRetainNonConfigurationInstance(): Any {
        // удаляем из MyTask ссылку на старое MainActivity
        task?.unLink()
        return Pair<List<Person>, AddListItemsTask?>(mainPersonList, task)
    }

    private fun showCard(person: Person) {
        Snackbar.make(binding.root, "Нажата карточка: " + person.name, 2000).show()
    }

    private fun showLike(person: Person) {
        Snackbar.make(binding.root, "Нажат лайк:  " + person.name, 2000).show()
    }


    private class AddListItemsTask : AsyncTask<Int?, Int?, Long>() {

        val personList = PersonHolder.createCollectionItems()


        var activity: MainActivity? = null


        fun link(act: MainActivity) {
            activity = act
        }

        fun unLink() {
            activity = null
        }

        override fun onPostExecute(result: Long) {

        }

        override fun doInBackground(vararg p0: Int?): Long {
            for (index in personList.indices) {
                Thread.sleep(2000)

                publishProgress(index)
            }
            return 0
        }

        override fun onProgressUpdate(vararg values: Int?) {
            activity!!.addData(personList[values[0]!!])
        }
    }

}
