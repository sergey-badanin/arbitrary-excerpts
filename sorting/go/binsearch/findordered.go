package binsearch

type BuiltInOrdered interface {
	~string | ~int | ~int8 | ~int16 | ~int32 | ~int64 | ~float32 | ~float64 | ~uint | ~uint8 | ~uint16 | ~uint32 | ~uint64 | ~uintptr
}

func FindOrdered[T BuiltInOrdered](ref T, items []T) (int, bool) {

	left := 0
	right := len(items) - 1
	for left <= right {
		middle := (right + left) / 2

		switch middleItem := items[middle]; {
		case middleItem > ref:
			right = middle - 1
		case middleItem < ref:
			left = middle + 1
		default:
			return middle, true
		}
	}

	return 0, false
}
