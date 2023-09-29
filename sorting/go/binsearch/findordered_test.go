package binsearch

import "testing"

func TestFindOrderedOnEdgeCaseSingleElementSlice(t *testing.T) {

	givenItems := []int{67}
	givenToFind := 67

	expected := 0
	actual, found := FindOrdered(givenToFind, givenItems)
	if !found || actual != expected {
		t.Errorf("Unexpected result: %v, %v for given slice of items: %v", actual, found, givenItems)
	}

}

func TestFindOrderedOnEdgeCaseEmptySlice(t *testing.T) {

	givenItems := []int{}
	givenToFind := 67

	expected := 0
	actual, found := FindOrdered(givenToFind, givenItems)
	if found || actual != expected {
		t.Errorf("Unexpected result: %v, %v for given slice of items: %v", actual, found, givenItems)
	}

}

func TestFindOrderedOnCommonCaseRefPresent(t *testing.T) {

	givenItems := []int{1, 3, 5, 7, 8}
	givenToFind := 5

	expected := 2
	actual, found := FindOrdered(givenToFind, givenItems)
	if !found || actual != expected {
		t.Errorf("Unexpected result: %v, %v for given slice of items: %v", actual, found, givenItems)
	}

}

func TestFindOrderedOnCommonCaseRefIsNotPresent(t *testing.T) {

	givenItems := []int{1, 2, 3, 4, 5, 6, 7}
	givenToFind := 0

	expected := 0
	actual, found := FindOrdered(givenToFind, givenItems)
	if found || actual != expected {
		t.Errorf("Unexpected result: %v, %v for given slice of items: %v", actual, found, givenItems)
	}

}

func TestFindOrderedOnCornerCaseRefIsFirst(t *testing.T) {

	givenItems := []int{1, 2, 3}
	givenToFind := 1

	expected := 0
	actual, found := FindOrdered(givenToFind, givenItems)
	if !found || actual != expected {
		t.Errorf("Unexpected result: %v, %v for given slice of items: %v", actual, found, givenItems)
	}

}

func TestFindOrderedOnCornerCaseRefIsLast(t *testing.T) {

	givenItems := []int{1, 2, 3}
	givenToFind := 3

	expected := 2
	actual, found := FindOrdered(givenToFind, givenItems)
	if !found || actual != expected {
		t.Errorf("Unexpected result: %v, %v for given slice of items: %v", actual, found, givenItems)
	}

}
