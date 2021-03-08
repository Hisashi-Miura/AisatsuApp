package jp.techacademy.hisashi.miura.aisatsuapp



import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.text = "ボタン"
        textView.text = "上手にあいさつできるかな？"//初期テキストメッセージ
        button1.setOnClickListener(this)
    }
    
    override fun onClick(v: View) {
        Log.d("UI_PARTS", "ボタンをタップしました")
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")

                if (2<=hour && hour<10){//取得したhourから、条件分岐であいさつ
                    Log.d("UI_PARTS", "おはよう")
                    textView.text = "おはよう"
                } else if(10<=hour && hour<18){
                    Log.d("UI_PARTS", "こんにちは")
                    textView.text = "こんにちは"
                } else {
                    Log.d("UI_PARTS", "こんばんは")
                    textView.text = "こんばんは"
                }
            }
            ,13, 0, true)
        timePickerDialog.show()
    }
}
