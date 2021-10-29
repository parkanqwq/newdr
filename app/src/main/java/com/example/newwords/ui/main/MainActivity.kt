package com.example.newwords.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.newwords.R
import com.example.newwords.databinding.ActivityMainBinding
import com.example.newwords.domain.PersonEntity
import com.example.newwords.domain.PersonRepo
import com.example.newwords.impl.PersonRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val personRepo: PersonRepo = PersonRepoImpl()
//    private var currentDisposable: Disposable? = null
//    set(value) {
//        field?.takeIf { !it.isDisposed }?.dispose()
//        field = value
//    }
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        //test
    }

    private fun initView() = with(binding){
        val personModel = intent.getSerializableExtra(PERSON_EDIT_KEY) as? PersonEntity
        nameProfile.text = resources.getString(R.string.text_hi) + personModel?.name
        agePerson.text = resources.getString(R.string.text_age_person) + personModel?.age.toString()
        powerPerson.text = resources.getString(R.string.text_power_person) + personModel?.power.toString()

        buttonChangeName.setOnClickListener {
            val name = editTextNewName.text.toString()
            var age = editTextNewAge.text.toString().toInt()
            if (name.isNotBlank() && age.toString().isNotBlank()) {
                age = 55
                personRepo.add(PersonEntity(id = UUID.randomUUID().toString(), name, age, 55))
            } else Toast.makeText(this@MainActivity, R.string.strings_is_empty, Toast.LENGTH_SHORT).show()
        }
//        currentDisposable = personRepo.person.subscribe {
//            nameProfile.text = "$it 1, "
//        }
        compositeDisposable.add(
            personRepo.person
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { listPerson -> nameProfile.text = listPerson.name },
                    { thr -> Toast.makeText(this@MainActivity, thr.message, Toast.LENGTH_SHORT).show() }
                )
        )
        compositeDisposable.add(
            personRepo.person
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { listPerson -> agePerson.text = listPerson.age.toString() },
                    { thr -> Toast.makeText(this@MainActivity, thr.message, Toast.LENGTH_SHORT).show() }
                )
        )
    }

    companion object {
        private const val PERSON_EDIT_KEY = "person_keys"

        fun createLauncherIntent(context: Context, personEntity: PersonEntity?) : Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(PERSON_EDIT_KEY, personEntity)
            return intent
        }
    }

    override fun onDestroy() {
//        currentDisposable = null
        compositeDisposable.dispose()
        super.onDestroy()
    }
}

