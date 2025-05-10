fun majorityElement(nums: IntArray): Int {
    // La función sort() Hace uso de java.util.Arrays.sort() que usa un algoritmo
    // que combina el QuickSort junto con el MergeSort
    nums.sort()
    val middle = (nums[nums.size / 2])
    val isMajority = nums.count { it == middle } >= nums.size / 2
    return if (isMajority) middle else -1
}
