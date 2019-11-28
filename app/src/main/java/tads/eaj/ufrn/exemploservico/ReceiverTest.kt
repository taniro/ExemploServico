package tads.eaj.ufrn.exemploservico

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReceiverTest : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.startService(Intent(context, ServicoTest::class.java))
    }
}
