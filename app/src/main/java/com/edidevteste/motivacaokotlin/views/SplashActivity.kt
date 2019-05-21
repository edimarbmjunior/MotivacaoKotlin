package com.edidevteste.motivacaokotlin.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.edidevteste.motivacaokotlin.R
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
        verifyUserName()
    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.buttonSalvar){
            handleSalve()
        }
    }

    private fun handleSalve(){
        val name: String = editName.text.toString()
        if(name.isNullOrBlank()){
            Toast.makeText(applicationContext /* Ou "this"*/, getString(R.string.informe_nome), Toast.LENGTH_LONG).show()
        }else{
            mSecurity.storeString(MotivacaoConstants.KEY.PERSON_NAME, name)

            //Criação da variavel com os dados da aplicação e qual a intenção de abertura
            //val intent = Intent(this, MainActivity::class.java)
            //Chamada de activity usando variavel com a intenção(intent)
            startNewActivity(Intent(this, MainActivity::class.java))

            //A função abaixo retira da pilha de activity abertas e funcionais a "splashActivity", impede que volte para ela
            // Porém caso o aplicativo seja retirado da memória do aparelho, o app voltará a ter a activity "splashActivity"
            //finish()
        }
    }

    private fun startNewActivity(intent: Intent){
        startActivity(intent)
    }

    private fun verifyUserName(){
        val userName = mSecurity.getStoredString(MotivacaoConstants.KEY.PERSON_NAME)
        if(!userName.isNullOrBlank()){
            editName.setText(userName)
            startNewActivity(Intent(this, MainActivity::class.java))
        }
    }
}
