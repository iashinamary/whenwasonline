fun main() {
    val secondsToText = 79200
    agoToText(secondsToText)
}

fun agoToText(secondToText: Int){
    val textSeparator = " "
    val wasHere = "был(а)"
    print(wasHere)
    print(textSeparator)
    if (secondsToHoursOrDays(secondToText) == ""){
        print(secondsToHoursOrDays(secondToText))
    } else {
        print(secondsToHoursOrDays(secondToText))
        print(textSeparator)
    }
    print(howLongAgo(secondToText))
}

fun howLongAgo(secondToText: Int): String {
    val text = when(secondToText){
        in 0..60 -> "только что"
        in 61..60 * 60 -> checkEndOfMinutes(secondToText)
        in 60 * 60 + 1..24 * 60 * 60 -> checkEndOfHours(secondToText)
        in 24 * 60 * 60 + 1.. 48 * 60 * 60 -> "вчера"
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
    return text
}

fun checkEndOfHours(secondToText: Int): String {
    return when (secondToText/ (60 * 60)){
        1, 21 -> "час назад"
        in 2..4, in 22..23 -> "часа назад"
        else -> "часов назад"
    }
}

fun checkEndOfMinutes(secondToText: Int): String {
   return when (secondToText/60%10){
        1 -> "минуту назад"
        2, 3, 4 -> "минуты назад"
        in 5..9-> "минут назад"
        else -> "минут назад"
    }
}

fun secondsToHoursOrDays(secondToText: Int): String {
    val time = when(secondToText){
        in 61..60 * 60 -> (secondToText / 60).toString()
        in 60 * 60 + 1..24 * 60 * 60 -> (secondToText / (60 * 60)).toString()
        else -> ""
    }
    return time
}
