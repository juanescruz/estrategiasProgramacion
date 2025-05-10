fun countSmaller(nums: List<Int>): IntArray {
    val n = nums.size
    val elements = nums.mapIndexed { i, v -> Element(v, i) }
    val counts = IntArray(n)


    fun merge(left: List<Element>, right: List<Element>): List<Element> {
        val merged = mutableListOf<Element>()
        var i = 0       // pointer in left
        var j = 0       // pointer in right
        var rightCounter = 0  // how many from right have been placed


        while (i < left.size && j < right.size) {
            if (left[i].value <= right[j].value) {
                // all 'rightCounter' right-items are smaller than left[i]
                counts[left[i].index] += rightCounter
                merged += left[i++]
            } else {
                // take from right, it’s smaller than the current left
                rightCounter++
                merged += right[j++]
            }
        }
        // exhaust remaining left
        while (i < left.size) {
            counts[left[i].index] += rightCounter
            merged += left[i++]
        }
        // exhaust remaining right (no counting needed)
        while (j < right.size) {
            merged += right[j++]
        }
        return merged
    }


    fun mergeSort(arr: List<Element>): List<Element> {
        if (arr.size <= 1) return arr
        val mid = arr.size / 2
        val left = mergeSort(arr.subList(0, mid))
        val right = mergeSort(arr.subList(mid, arr.size))
        return merge(left, right)
    }
    mergeSort(elements)
    return counts
}
