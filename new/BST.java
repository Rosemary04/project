public class BST {
    private BSTNode root;

    public BST() {
        root = null;
    }

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private BSTNode insertRec(BSTNode root, Student student) {
        if (root == null) {
            root = new BSTNode(student);
            return root;
        }
        if (student.getId() < root.student.getId()) {
            root.left = insertRec(root.left, student);
        } else if (student.getId() > root.student.getId()) {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public Student search(int id) {
        return searchRec(root, id);
    }

    private Student searchRec(BSTNode root, int id) {
        if (root == null || root.student.getId() == id) {
            return (root != null) ? root.student : null;
        }
        if (root.student.getId() > id) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private BSTNode deleteRec(BSTNode root, int id) {
        if (root == null) {
            return root;
        }
        if (id < root.student.getId()) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.student.getId()) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.student = findMin(root.right).student;
            root.right = deleteRec(root.right, root.student.getId());
        }
        return root;
    }

    private BSTNode findMin(BSTNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.student);
            inorderRec(root.right);
        }
    }
}
