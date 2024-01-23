package twopointers

import "testing"

func TestMoveZeros01(t *testing.T) {

	givenNums := []int{1, 0, 2, 0, 0, 7}
	expectedNums := []int{1, 2, 7, 0, 0, 0}

	MoveZeros(givenNums)

	if !testEq(givenNums, expectedNums) {
		t.Errorf("Unexpected result, slices are not equal %v, %v", givenNums, expectedNums)
	}

}

func testEq(a, b []int) bool {
	for i, v := range a {
		if v != b[i] {
			return false
		}
	}
	return true
}
