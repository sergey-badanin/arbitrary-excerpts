pub mod find_first_not_smaller {
    pub fn find_first_not_smaller(items: &Vec<isize>, target: isize) -> Option<usize> {
        let mut left: isize = 0;
        let mut right: isize = items.len() as isize - 1 ;
        let mut target_idx = None;
        while left <= right {
            let mid = ((right + left) / 2) as usize;
            if items[mid] >= target {
                target_idx = Some(mid);
                right = mid as isize - 1;
            } else {
                left = mid as isize + 1;
            }
        }
        return target_idx;
    }
    
    #[cfg(test)]
    mod tests {
        use super::*;
    
        #[test]
        fn test_edge_case_single_elem_vector() {
            let given = vec![1];
            let target = 1;
    
            let expected = Some(0);
            let actual = find_first_not_smaller(&given, target);
            assert_eq!(expected, actual)
        }
    
        #[test]
        fn test_edge_case_empty_vector() {
            let given = vec![];
            let target = 34;
    
            let expected = None;
            let actual = find_first_not_smaller(&given, target);
            assert_eq!(expected, actual)
        }    
    
        #[test]
        fn test_edge_case_fist_is_target() {
            let given = vec![34, 35, 36, 37];
            let target = 34;
    
            let expected = Some(0);
            let actual = find_first_not_smaller(&given, target);
            assert_eq!(expected, actual)
        }
    
        #[test]
        fn test_edge_case_last_is_target() {
            let given = vec![31, 32, 33, 34];
            let target = 34;
    
            let expected = Some(3);
            let actual = find_first_not_smaller(&given, target);
            assert_eq!(expected, actual)
        }
    
        #[test]
        fn test_common_case_target_in_the_middle() {
            let given = vec![33, 34, 35];
            let target = 34;
    
            let expected = Some(1);
            let actual = find_first_not_smaller(&given, target);
            assert_eq!(expected, actual)
        }        
    }    
}