package binsearch

func FindBool(items []bool) int {

	left := 0
	right := len(items) - 1
	trueIdx := -1
	for left <= right {
		mid := left + (right-left)/2

		if items[mid] {
			trueIdx = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return trueIdx
}
