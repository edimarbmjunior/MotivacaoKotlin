package com.edidevteste.motivacaokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.edidevteste.motivacaokotlin.util.MotivacaoConstants
import com.edidevteste.motivacaokotlin.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    //Aplicado a função (lateinit) que atrasa o instanciamento, para instaciar no onCreate(), pois a securityPrefenrence tem que ser
    // instanciada, para não ter proplema de isntaciar na criação da variavel, pois na criação da variavel não exite contexto, só
    // existirá contexto quanto rodar onCreate()

    private lateinit var mSecurity: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mSecurity = SecurityPreferences(this)
        buttonSalvar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.buttonSalvar){
            handleSalve()
        }
    }

    private fun handleSalve(){
        val name: String = editName.text.toString()
        mSecurity.storeString(MotivacaoConstants.KEY.PERSON_NAME, name)
    }
}
