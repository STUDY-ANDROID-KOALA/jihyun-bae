class Solution {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        val times = LongArray(toTime(play_time) + 1) { 0L }
        
        for (log in logs.indices) {
            val l = logs[log].split("-")
            
            times[toTime(l[0])] += 1L
            times[toTime(l[1])] -= 1L
        }
        
        for (time in 1..times.size - 1) {
            times[time] = times[time - 1] + times[time]
        }
        
        for (time in 1..times.size - 1) {
            times[time] = times[time - 1] + times[time]
        }
        
        var mostView = 0L
        var maxTime = 0L
        val advTime = toTime(adv_time)
        
        for (i in advTime - 1..times.size - 1) {
            if (i >= advTime) {
                if (mostView < times[i] - times[i - advTime]) {
                    mostView = times[i] - times[i - advTime]
                    maxTime = (i - advTime + 1).toLong()
                }
            }
            
            else {
                if (mostView < times[i]) {
                    mostView = times[i]
                    maxTime = (i - advTime + 1).toLong()
                }
            }
        }
        
        return toClock(maxTime)
        //return t.toString()
    }
    
    fun toTime(time: String): Int {
        val (t, m, s) = time.split(":").map { it.toInt() }
        
        return t * 3600 + m * 60 + s
    }
    
    fun toClock(time:Long): String {
        val h = time / 3600
        val m = (time % 3600) / 60
        val s = time % 60

        return "%02d:%02d:%02d".format(h, m, s)
    }
}
