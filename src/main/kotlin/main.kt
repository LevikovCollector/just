
fun main(){
    val value = 172812
    val textAgo = agoToText(value)
    println("был(а) $textAgo")
}

fun agoToText (second:Int):String {
    return when {
        second in 0..60 ->  "только что"
        second in 61..3599 ->  printMinutesText(second)
        second in 3600..86399 ->  printHourText(second)
        second in 86400..172800 -> "сегодня"
        second in 172801..259200 -> "вчера"
        second >= 259201 -> "давно"
        else -> "Не удалось определить значение"
    }
}

fun printMinutesText(second: Int):String{
    val minutes = convertSecondToMinutes(second)
    val minutesText = returnTextForMinutes(minutes)
    return ("$minutes $minutesText назад")
}

fun printHourText(second: Int):String{
    val hours = convertSecondToHour(second)
    val hoursText = returnTextForHours(hours)
    return("$hours $hoursText назад")
}

fun returnTextForMinutes(minutes:Int):String{
    var text = ""
    val minutesDelta = minutes % 10

    if (minutesDelta == 1 && minutes != 11){
        text = "минуту"
    } else if (minutesDelta in 2..4)
    {
        text = "минуты"
    } else{
        text = "минут"
    }

    return text
}

fun returnTextForHours(hour:Int):String{
    var text = ""
    val hourDelta = hour % 10

    if (hourDelta == 1 && hour != 11){
        text = "час"
    } else if (hourDelta in 2..4)
    {
        text = "часа"
    } else{
        text = "часов"
    }

    return text
}


fun convertSecondToMinutes(second:Int):Int{
    return second / 60
}

fun convertSecondToHour(second:Int):Int{
    return second /3600
}

