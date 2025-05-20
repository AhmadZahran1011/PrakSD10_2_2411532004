package pekan5;

public class NodeSLL {
	int data;	// node bagian data
	NodeSLL next;	// pointer ke node berikutnya 
	// konstruktor menginisialisasi node dengan data
	public NodeSLL(int data) {
		this.data = data;
		this.next = null;
	}
}
