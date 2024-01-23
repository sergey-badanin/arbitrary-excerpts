package twopointers

func MoveZeros(nums []int) {

	slow := 0
	fast := 0

	for fast < len(nums) {

		if fast != slow && nums[fast] != 0 {
			nums[slow] = nums[fast]
			nums[fast] = 0
			fast++
			slow++
			continue
		}
		if nums[fast] == 0 {
			fast++
			continue
		}
		fast++
		slow++
	}

}
