import kotlin.io.*
import java.util.*


fun partitional(arr: Array<Int>, left: Int, right: Int): Int {
    var tmp = arr[(left + right) / 2]
    var i = left
    var j = right
    while (i <= j) {
        while (arr[i] < tmp)
            i++
        while (arr[j] > tmp)
            j--
        if (i >= j)
            break
        tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
        j--
        i++
    }
    return j
}

fun findOrderStatistic(array: Array<Int>, k: Int): Int {
    var left = 0
    var cicleK = k
    var right = array.size
    while (true) {
        var middle = partitional(array, left, right-1)
        when {
            cicleK == middle -> return array[middle]
            cicleK < middle -> right = middle
            else -> {
                cicleK -= middle + 1
                left = middle + 1
            }
        }
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()
    val arr = Array<Int>(n, { 0 })
    for (i in 0..n - 1) {
        arr[i] = scan.nextInt()
    }
    val k = scan.nextInt() //sought statistics
    println(findOrderStatistic(arr, k))
}