package binsearch

import "testing"

func TestFindBoolOnEdgeCaseSingleElementSlice(t *testing.T) {

	givenItems := []bool{false}

	expected := -1
	actual := FindBool(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v for given slice of items: %v", actual, givenItems)
	}
}

func TestFindBoolOnEdgeCaseEmptySlice(t *testing.T) {

	givenItems := []bool{}

	expected := -1
	actual := FindBool(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v for given slice of items: %v", actual, givenItems)
	}
}

func TestFindBoolOnCommonCaseRefPresent(t *testing.T) {

	givenItems := []bool{false, false, true, true, true}

	expected := 2
	actual := FindBool(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v for given slice of items: %v", actual, givenItems)
	}
}

func TestFindBoolOnCommonCaseRefIsNotPresent(t *testing.T) {

	givenItems := []bool{false, false, false, false, false}

	expected := -1
	actual := FindBool(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v for given slice of items: %v", actual, givenItems)
	}
}

func TestFindBoolOnCornerCaseRefIsFirst(t *testing.T) {

	givenItems := []bool{true, true}

	expected := 0
	actual := FindBool(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v for given slice of items: %v", actual, givenItems)
	}
}

func TestFindBoolOnCornerCaseRefIsLast(t *testing.T) {

	givenItems := []bool{false, true}

	expected := 1
	actual := FindBool(givenItems)
	if actual != expected {
		t.Errorf("Unexpected result: %v for given slice of items: %v", actual, givenItems)
	}
}
