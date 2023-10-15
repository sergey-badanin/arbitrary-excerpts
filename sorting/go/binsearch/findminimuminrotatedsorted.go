package binsearch

func FindInRotated(arr []int) int {
	leftIdx := 0
	rightIdx := len(arr) - 1

	targetIdx := -1
	target := arr[rightIdx]

	for leftIdx <= rightIdx {
		midIdx := (leftIdx + rightIdx) / 2
		if arr[midIdx] <= target {
			rightIdx = midIdx - 1
			targetIdx = midIdx
		} else if arr[midIdx] > target {
			leftIdx = midIdx + 1
		}
	}

	return targetIdx
}
