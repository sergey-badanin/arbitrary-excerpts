package binsearch

import "testing"

func TestFindInRotatedForEdgeCaseSingleElementSlice(t *testing.T) {

	givenItems := []int{67}
	expected := 0
	actual := FindInRotated(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v, for given slice of items: %v", actual, givenItems)
	}
}

func TestFindInRotatedForEdgeCase2ItemsArray01(t *testing.T) {

	givenItems := []int{22, 33}
	expected := 0
	actual := FindInRotated(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v, for given slice of items: %v", actual, givenItems)
	}
}

func TestFindInRotatedForEdgeCase2ItemsArray02(t *testing.T) {

	givenItems := []int{33, 22}
	expected := 1
	actual := FindInRotated(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v, for given slice of items: %v", actual, givenItems)
	}
}

func TestFindInRotatedForEdgeCase3ItemsArray01(t *testing.T) {

	givenItems := []int{11, 22, 33}
	expected := 0
	actual := FindInRotated(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v, for given slice of items: %v", actual, givenItems)
	}
}

func TestFindInRotatedForEdgeCase3ItemsArray02(t *testing.T) {

	givenItems := []int{22, 33, 11}
	expected := 2
	actual := FindInRotated(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v, for given slice of items: %v", actual, givenItems)
	}
}

func TestFindInRotatedForEdgeCase3ItemsArray03(t *testing.T) {

	givenItems := []int{33, 11, 22}
	expected := 1
	actual := FindInRotated(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v, for given slice of items: %v", actual, givenItems)
	}
}

func TestFindInRotatedForEdgeCaseRandomArray01(t *testing.T) {

	givenItems := []int{4, 5, 6, 1, 2, 3}
	expected := 3
	actual := FindInRotated(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v, for given slice of items: %v", actual, givenItems)
	}
}

func TestFindInRotatedForEdgeCaseRandomArray02(t *testing.T) {

	givenItems := []int{5, 6, 1, 2, 3, 4}
	expected := 2
	actual := FindInRotated(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v, for given slice of items: %v", actual, givenItems)
	}
}
