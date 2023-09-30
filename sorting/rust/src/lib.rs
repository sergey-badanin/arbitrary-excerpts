pub fn find_first_not_smaller(items: &Vec<i32>, target: i32) -> Option<usize> {
    



    return None
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_edge_case_() {
            let given = vec![1];
            let target = 1;

            let expected = None;
            let actual = find_first_not_smaller(&given, target);
            assert_eq!(expected, actual)
    }
}
