import kotlin.io.*
import java.util.*


fun merge(array: Array<Int>, left: Int, middle: Int, right: Int) {
    val result = Array<Int>(right - left, { 0 })
    var i = 0
    var j = 0
    while ((left + i < middle) and (middle + j < right)) {
        if (array[left + i] < array[middle + j]) {
            result[i + j] = array[left + i]
            i++
        } else {
            result[i + j] = array[middle + j]
            j++
        }
    }
    while (left + i < middle) {
        result[i + j] = array[left + i]
        i++
    }
    while (middle + j < right) {
        result[i + j] = array[middle + j]
        j++
    }
    for (n in 0..i + j - 1)
        array[left + n ] = result[n]
}

fun mergeSortIterative(array: Array<Int>) {
    val size = array.size
    var n = 1
    for (i in 1..size step n) {
        for (j in 0..size - i step 2 * i)
            merge(array, j, j + i, Math.min(j + 2 * i, size))
        n *= 2
    }
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()
    val arr = Array<Int>(n, { 0 })
    for (i in 0..n - 1) {
        arr[i] = scan.nextInt()
    }
    mergeSortIterative(arr)
    for (i in 0..n - 1)
        println(arr[i])

}