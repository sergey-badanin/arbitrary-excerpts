use std::{cell::RefCell, rc::Rc};

#[derive(Debug, Clone)]
pub struct Node {
    pub val: i32,
    pub left: Option<NodeRef>,
    pub right: Option<NodeRef>,
}

impl Node {
    pub fn new(val: i32) -> Self {
        Node {
            val: val,
            left: Option::None,
            right: Option::None,
        }
    }
}

pub type NodeRef = Rc<RefCell<Node>>;

pub fn build_tree_stack(tree: &String) -> NodeRef {
    let mut nodes: Vec<&str> = tree.split(' ').rev().collect();
    println!("{:?}", nodes);
    let val = nodes.pop().unwrap().parse::<i32>().unwrap();
    let root = Rc::new(RefCell::new(Node::new(val)));

    let mut nodes_stack = vec![(Rc::clone(&root), false, false)];
    while !nodes_stack.is_empty() {
        let (val_ref, left_visited, right_visited) = nodes_stack.pop().unwrap();

        if !left_visited {
            let next_node = nodes.pop();
            if let Some(next_val) = next_node {
                if next_val == "x" {
                    println!(
                        "For node: {:?} left child is set: {:?}",
                        val_ref.borrow().val,
                        next_val
                    );
                    val_ref.borrow_mut().left = None;
                    nodes_stack.push((val_ref, true, false));
                    continue;
                }
                let next_val = next_val.parse::<i32>().unwrap();
                nodes_stack.push((val_ref, true, false));
                nodes_stack.push((Rc::new(RefCell::new(Node::new(next_val))), false, false));
                continue;
            }
        }

        if !right_visited {
            let next_node = nodes.pop();
            if let Some(next_val) = next_node {
                if next_val == "x" {
                    println!(
                        "For node: {:?} right child is set: {:?}",
                        val_ref.borrow().val,
                        next_val
                    );
                    val_ref.borrow_mut().right = None;
                    nodes_stack.push((val_ref, true, true));
                    continue;
                }
                let next_val = next_val.parse::<i32>().unwrap();
                nodes_stack.push((val_ref, true, true));
                nodes_stack.push((Rc::new(RefCell::new(Node::new(next_val))), false, false));
                continue;
            }
        }

        if !nodes_stack.is_empty() {
            let (parent, _, right_visited) = nodes_stack.pop().unwrap();
            if !right_visited {
                println!(
                    "For parent: {:?} left child is set: {:?}",
                    parent.borrow().val,
                    val_ref.borrow().val
                );
                parent.borrow_mut().left = Some(Rc::clone(&val_ref));
                nodes_stack.push((parent, true, false));
                continue;
            }
            println!(
                "For parent: {:?} right child is set: {:?}",
                parent.borrow().val,
                val_ref.borrow().val
            );
            parent.borrow_mut().right = Some(Rc::clone(&val_ref));
            nodes_stack.push((parent, true, true));
            continue;
        } else {
            println!("Root node: {:?}", val_ref.borrow().val);
        }
    }

    root
}

fn dfs_visit(root_ref: &NodeRef) {
    println!(" {} ", root_ref.borrow().val);

    if let Some(left_ref) = root_ref.borrow().left.as_ref() {
        dfs_visit(left_ref);
    }

    if let Some(right_ref) = root_ref.borrow().right.as_ref() {
        dfs_visit(right_ref);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_build_tree() {
        let root = build_tree_stack(&String::from("1 2 3 x x x 6 x x"));
        println!("Root is: {:?}", root);
    }

    #[test]
    fn test_dfs_visit() {
        let root = build_tree_stack(&String::from("1 2 3 x x x 6 x x"));
        dfs_visit(&root);
    }
}
