package com.edidevteste.motivacaokotlin.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.edidevteste.motivacaokotlin.R
import com.edidevteste.motivacaokotlin.util.MotivacaoConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFilter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFilter = MotivacaoConstants.PHRASE_FILTER.ALL
        refreshImagens()
        imageAll.setImageResource(R.drawable.ic_all_selected)

        setListeners()
    }

    private fun setListeners(){
        imageAll.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        val listImage = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageSun)
        if(id in listImage){
            handleFilter(id)
        }else{
            refreshPrase()
        }
    }

    private fun refreshImagens(){
        imageAll.setImageResource(R.drawable.ic_all_unselected)
        imageSun.setImageResource(R.drawable.ic_sun_unselected)
        imageHappy.setImageResource(R.drawable.ic_happy_unselected)
    }

    private fun handleFilter(id: Int){
        refreshImagens()
        if(id == R.id.imageAll){
            mFilter = MotivacaoConstants.PHRASE_FILTER.ALL
            //Acertando quais imagens devem aparecer na tela
            imageAll.setImageResource(R.drawable.ic_all_selected)
        }else if(id == R.id.imageSun){
                mFilter = MotivacaoConstants.PHRASE_FILTER.SUN
                //Acertando quais imagens devem aparecer na tela
                imageSun.setImageResource(R.drawable.ic_sun_selected)
            }else if(id == R.id.imageHappy){
                    mFilter = MotivacaoConstants.PHRASE_FILTER.HAPPY
                    //Acertando quais imagens devem aparecer na tela
                    imageHappy.setImageResource(R.drawable.ic_happy_selected)
        }
    }

    private fun refreshPrase(){
        Toast.makeText(applicationContext, "Gerar código para geração automatica", Toast.LENGTH_LONG).show()
    }
}