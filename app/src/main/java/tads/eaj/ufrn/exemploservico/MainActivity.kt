package tads.eaj.ufrn.exemploservico

import android.Manifest.permission.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageManager
import android.content.Intent
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PermissionUtils.validate(this, 0, READ_SMS, READ_PHONE_STATE, RECEIVE_SMS);
    }

    fun startService(view: View) {
        startService(Intent(this, ServicoTest::class.java))
    }

    fun stopService(view: View) {
        stopService(Intent(this, ServicoTest::class.java))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for (result in grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                // Alguma permissão foi negada, agora é com você :-)
                finish()
                return
            }
        }
        // Se chegou aqui está OK :-)
    }
}
