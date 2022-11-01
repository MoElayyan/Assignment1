package com.example.elecbill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.Resultbt)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val resultTV: TextView = findViewById(R.id.Result)
        //global variable
        var flag : String = "foreigner"
        //here .. create a spinner items (options)
        val spinnerVal : Spinner = findViewById(R.id.spinner)
        var options = arrayOf("foreigner","citizen")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )

        button.setOnClickListener{ view ->
            //code here
            var x: Int = edtxt1.text.toString().toInt();
            if(flag =="foreigner")
                resultTV.text = foreigner(x).toString();
            else
                resultTV.text = citizen(x).toString();
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
public fun foreigner(a: Int): Double {
    return a* 0.3
}
public fun citizen(a: Int): Double {
    return a* 0.1
}