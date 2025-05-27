package pekan6;


public class NodeDLL {
	int data;	// node bagian data
	NodeDLL next;	// pointer ke node berikutnya
	NodeDLL prev;
	// konstruktor menginisialisasi node dengan data
	public NodeDLL(int data) {
		this.data = data;
		this.next = null;
	}
}

