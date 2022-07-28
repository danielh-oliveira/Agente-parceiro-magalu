package br.com.daniel.agenteparceiromagalu.ui.agenda

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.daniel.agenteparceiromagalu.R
import br.com.daniel.agenteparceiromagalu.databinding.ActivityAdicionaAgendamentoBinding
import br.com.daniel.agenteparceiromagalu.model.Loja
import br.com.daniel.agenteparceiromagalu.model.Tags
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class AdicionaAgendamentoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionaAgendamentoBinding.inflate(
            LayoutInflater.from(
                this
            )
        )
    }

    private val dateRangePicker by lazy {
        MaterialDatePicker.Builder.datePicker()
            .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .setTitleText(getString(R.string.title_date_picker))
            .build()
    }

    private val timePicker by lazy {
        MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(12)
            .setMinute(10)
            .build()
    }

    private val adicionaViewModel: AdicionaAgendamentoViewModel by viewModels()

    private lateinit var data: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.topAppBarAdd.setNavigationOnClickListener {
            finish()
        }
        
        binding.buttonPickDate.setOnClickListener {
            dateRangePicker.show(supportFragmentManager, "tagDate")
        }

        dateRangePicker.addOnPositiveButtonClickListener {
            binding.tfDateAgendamento.text = dateRangePicker.headerText
            timePicker.show(supportFragmentManager, "tagTime")
        }

        timePicker.addOnPositiveButtonClickListener {
            data = timePicker.hour.toString() + ":" + timePicker.minute.toString()
            binding.tfHoraAgendamento.text = data
        }

        binding.buttonAdicionarAgendamento.setOnClickListener {
            adicionaViewModel.salvarAgendamento(
                Loja(
                    0,
                    "Loja nova",
                    data,
                    21.999999999,
                    Tags.Esporte
                )
            )
            finish()
        }


        //mais configuracoes aqui: https://material.io/components/date-pickers/android#using-date-pickers
    }
}