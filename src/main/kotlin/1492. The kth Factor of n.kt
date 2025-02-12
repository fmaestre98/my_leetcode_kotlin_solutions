fun kthFactor(n: Int, k: Int): Int {

    var cont = 1
    var i = 1
    while (cont < k && i < (n / 2) + 1) {
        i++
        if (n % i == 0) {
            cont++
        }
    }

    return if (cont == k) i else if (cont == k - 1) n else -1
}