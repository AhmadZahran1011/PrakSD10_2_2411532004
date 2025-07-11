package pekan9;

public class TreeMain {

	public static void main(String[] args) {
		//Membuat pohon
		BTree tree = new BTree ();
		System.out.println("Jumlah simpul awal pohon: ");
		System.out.println(tree.countNodes());
		// menambahkan simpul data 1
		Node root = new Node(1);
		//menjadikan simpiul 1 sebagai root
		tree.setRoot(root);
		System.out.println("Jumlah simpul jika a=hanya ada root");
		System.out.println(tree.countNodes());
		Node node2 = new Node (2);
		Node node3 = new Node (3);
		Node node4 = new Node (4);
		Node node5 = new Node (5);
		Node node6 = new Node (6);
		Node node7 = new Node (7);
		root.setLeft(node2);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		root.setRight(node3);
		node3.setRight(node7);
		//set root
		tree.setCurrent(tree.getRoot());
		System.out.println("menampilkan simpul terakhir: ");
		System.out.println(tree.getCurrent().getData());
		System.out.println("Jumlah simpul; setelah simpul 7 ditambahkan");
		System.out.println(tree.countNodes());
		System.out.println("Inorder: ");
		tree.printInorder();
		System.out.println("\n Preorder: ");
		tree.printPreorder();
		System.out.println("\n Postorder: ");
		tree.printPostorder();
		System.out.println("\n menampilkan simpul dalam bentuk pohon: ");
		tree.print();

	}

}
