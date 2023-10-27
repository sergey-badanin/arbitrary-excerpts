pub mod tree {
    use std::{cell::RefCell, rc::Rc};

    #[derive(Debug, Clone)]
    pub struct Node {
        val: i32,
        // left: Option<NodeRef>,
        // right: Option<NodeRef>,
    }

    impl Node {
        pub fn new(val: i32) -> Self {
            Node {
                val: val,
                // left: Option::None,
                // right: Option::None,
            }
        }
    }

    type NodeRef = Rc<RefCell<Node>>;

    fn build_tree_stack(tree: &String) -> Node {
        let mut nodes: Vec<&str> = tree.split(' ').rev().collect();
        println!("{:?}", nodes);
        let val = nodes.pop().unwrap().parse::<i32>().unwrap();
        let root = Node::new(val);

        let mut nodes_stack = vec![(root, false, false)];
        while !nodes_stack.is_empty() {
            let (val, left_visited, right_visited) = nodes_stack.pop().unwrap();

            if !left_visited {
                let next_node = nodes.pop();
                if let Some(next_val) = next_node {
                    if next_val == "x" {
                        println!("For node: {:?} left child is set: {:?}", val.val, next_val);
                        nodes_stack.push((val, true, false));
                        continue;
                    }
                    let next_val = next_val.parse::<i32>().unwrap();
                    nodes_stack.push((val, true, false));
                    nodes_stack.push((Node::new(next_val), false, false));
                    continue;
                }
            }

            if !right_visited {
                let next_node = nodes.pop();
                if let Some(next_val) = next_node {
                    if next_val == "x" {
                        println!("For node: {:?} right child is set: {:?}", val.val, next_val);
                        nodes_stack.push((val, true, true));
                        continue;
                    }
                    let next_val = next_val.parse::<i32>().unwrap();
                    nodes_stack.push((val, true, true));
                    nodes_stack.push((Node::new(next_val), false, false));
                    continue;
                }
            }

            if !nodes_stack.is_empty() {
                let (parent, _, right_visited) = nodes_stack.pop().unwrap();
                if !right_visited {
                    println!(
                        "For node: {:?} left child is set: {:?}",
                        parent.val, val.val
                    );
                    nodes_stack.push((parent, true, false));
                    continue;
                }
                println!(
                    "For node: {:?} right child is set: {:?}",
                    parent.val, val.val
                );
                nodes_stack.push((parent, true, true));
                continue;
            } else {
                println!("Root node: {:?}", val.val);
            }
        }

        Node::new(22)
    }

    #[cfg(test)]
    mod tests {
        use super::*;

        #[test]
        fn test_build_tree() {
            let root = build_tree_stack(&String::from("1 2 3 x x x 6 x x"));
            println!("Root is: {:?}", root);
        }
    }
}
