use crate::bin_tree::tree;
use std::cmp;

fn tree_depth(root: &tree::NodeRef) -> i32 {
    let left_depth = match root.borrow().left.as_ref() {
        Some(left) => tree_depth(left),
        None => 0,
    };

    let right_depth = match root.borrow().right.as_ref() {
        Some(right) => tree_depth(right),
        None => 0,
    };

    cmp::max(left_depth, right_depth) + 1
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_build_tree() {
        let root = tree::build_tree_stack(&String::from("5 4 3 x x 8 x x 6 x x"));
        println!("Depth is: {:?}", tree_depth(&root));
        println!("Root is: {:?}", root);
    }
}
