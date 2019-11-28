package tads.eaj.ufrn.exemploservico

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class ServicoTest : Service() {

    var threads: MutableList<Worker> = ArrayList()


    override fun onBind(intent: Intent): IBinder? {
        // TODO Auto-generated method stub
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("Script", "onCreate()")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.i("Script", "onStartCommand()")

        val w = Worker(startId)
        w.start()
        threads.add(w)

        return super.onStartCommand(intent, flags, startId)
        // START_NOT_STICKY
        // START_STICKY
        // START_REDELIVER_INTENT
    }


    inner class Worker(var startId: Int) : Thread() {
        var count = 0
        var ativo = true

        override fun run() {
            while (ativo && count < 1000) {
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                }

                count++
                Log.i("Script", "COUNT: $count")
            }
            stopSelf(startId)
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        var i = 0
        val tam = threads.size
        while (i < tam) {
            threads[i].ativo = false
            i++
        }
    }
}
