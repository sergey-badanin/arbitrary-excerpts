pub mod peak_of_mountain {

    pub fn find_peak_of_mountain(items: &Vec<isize>) -> isize {
        let mut left: isize = 0;
        let mut right: isize = items.len() as isize - 1;

        while left < right {
            let mid = ((right + left) / 2) as usize;

            if items[mid] > items[mid + 1] {
                right = mid as isize;
            }
            if mid.checked_sub(1).is_some_and(|v| items[mid] > items[v]) {
                left = mid as isize;
            }
        }
        left
    }

    #[cfg(test)]
    mod tests {
        use super::*;

        #[test]
        fn test_simple_case_3_items() {
            let given = vec![3, 5, 4];

            let expected = 1;
            let actual = find_peak_of_mountain(&given);
            assert_eq!(expected, actual)
        }

        #[test]
        fn test_simple_case_01() {
            let given = vec![0, 1, 2, 3, 2, 1, 0];

            let expected = 3;
            let actual = find_peak_of_mountain(&given);
            assert_eq!(expected, actual)
        }

        #[test]
        fn test_simple_case_02() {
            let given = vec![0, 10, 3, 2, 1, 0];

            let expected = 1;
            let actual = find_peak_of_mountain(&given);
            assert_eq!(expected, actual)
        }

        #[test]
        fn test_simple_case_03() {
            let given = vec![0, 1, 2, 12, 22, 32, 42, 52, 62, 72, 82, 92, 102, 112, 122, 132, 133, 132, 111, 0];

            let expected = 16;
            let actual = find_peak_of_mountain(&given);
            assert_eq!(expected, actual)
        }        
    }
}
