import kotlin.math.max

fun main() {
    val nums1 = arrayOf(
        intArrayOf(148, 597),
        intArrayOf(165, 623),
        intArrayOf(306, 359),
        intArrayOf(349, 566),
        intArrayOf(403, 646),
        intArrayOf(420, 381),
        intArrayOf(566, 543),
        intArrayOf(730, 209),
        intArrayOf(757, 875),
        intArrayOf(788, 208),
        intArrayOf(932, 695)
    )

    // Definir la matriz nums2
    val nums2 = arrayOf(
        intArrayOf(74, 669),
        intArrayOf(87, 399),
        intArrayOf(89, 165),
        intArrayOf(99, 749),
        intArrayOf(122, 401),
        intArrayOf(138, 16),
        intArrayOf(144, 714),
        intArrayOf(148, 206),
        intArrayOf(177, 948),
        intArrayOf(211, 653),
        intArrayOf(285, 775),
        intArrayOf(309, 289),
        intArrayOf(349, 396),
        intArrayOf(386, 831),
        intArrayOf(403, 318),
        intArrayOf(405, 119),
        intArrayOf(420, 153),
        intArrayOf(468, 433),
        intArrayOf(504, 101),
        intArrayOf(566, 128),
        intArrayOf(603, 688),
        intArrayOf(618, 628),
        intArrayOf(622, 586),
        intArrayOf(641, 46),
        intArrayOf(653, 922),
        intArrayOf(672, 772),
        intArrayOf(691, 823),
        intArrayOf(693, 900),
        intArrayOf(756, 878),
        intArrayOf(757, 952),
        intArrayOf(770, 795),
        intArrayOf(806, 118),
        intArrayOf(813, 88),
        intArrayOf(919, 501),
        intArrayOf(935, 253),
        intArrayOf(982, 385)
    )

    mergeArrays(nums1, nums2).forEach {
        print(it[0].toString() + " " + it[1])
        println()
    }
}

fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {

    val n = nums1.size
    val m = nums2.size

    val result = mutableListOf<IntArray>()

    var i = 0
    var j = 0

    while (i < n || j < m) {
        while ((i < n && j < m) && nums1[i][0] == nums2[j][0]) {
            result.add(intArrayOf(nums1[i][0], nums1[i][1] + nums2[j][1]))
            i++
            j++
        }

        while ((i < n && j < m) && nums1[i][0] < nums2[j][0]) {
            result.add(intArrayOf(nums1[i][0], nums1[i][1]))
            i++
        }


        while ((i < n && j < m) && nums1[i][0] > nums2[j][0]) {
            result.add(intArrayOf(nums2[j][0], nums2[j][1]))
            j++
        }

        if(i < n && j >= m){
            result.add(intArrayOf(nums1[i][0], nums1[i][1]))
            i++
        }


        if(j < m && i >= n){
            result.add(intArrayOf(nums2[j][0], nums2[j][1]))
            j++
        }
    }

    return result.toTypedArray()
}


fun mergeArrays2(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var i = 0
    var j = 0

    while (i < nums1.size || j < nums2.size) {
        when {
            i < nums1.size && j < nums2.size && nums1[i][0] == nums2[j][0] -> {
                result.add(intArrayOf(nums1[i][0], nums1[i][1] + nums2[j][1]))
                i++
                j++
            }
            i < nums1.size && (j >= nums2.size || nums1[i][0] < nums2[j][0]) -> {
                result.add(intArrayOf(nums1[i][0], nums1[i][1]))
                i++
            }
            j < nums2.size && (i >= nums1.size || nums1[i][0] > nums2[j][0]) -> {
                result.add(intArrayOf(nums2[j][0], nums2[j][1]))
                j++
            }
        }
    }

    return result.toTypedArray()
}