package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val stateFlow: MutableStateFlow<Int>
) {

    fun generateColor() {
        if (context !is FragmentActivity) {
            throw RuntimeException("Здесь нужен контекст активити")
        }
        val color = colorGenerator.generateColor()
        stateFlow.value = color

        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}