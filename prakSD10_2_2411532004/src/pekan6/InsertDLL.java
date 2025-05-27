package pekan6;

public class InsertDLL {
    // fungsi menambahkan node di awal DLL
    static NodeDLL insertBegin(NodeDLL head, int data) {
        // buat node baru
        NodeDLL new_node = new NodeDLL(data);
        // jadikan pointer next-nya ke head
        new_node.next = head;
        // jika list tidak kosong, set prev head ke new_node
        if (head != null) {
            head.prev = new_node;
        }
        return new_node;
    }
    // fungsi menambahkan node di akhir
    public static NodeDLL insertEnd(NodeDLL head, int newData) {
        // buat node baru
        NodeDLL newNode = new NodeDLL(newData);
        // jika dll null jadikan head
        if (head == null) {
            head = newNode;
        } else {
            NodeDLL curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
        return head;
    }

//fungsi menambahkan node di posisi tertentu
public static NodeDLL insertAtPosition(NodeDLL head, int pos, int new_data) {
 // buat node baru
 NodeDLL new_node = new NodeDLL(new_data);
 if (pos == 1) {
     new_node.next = head;
     if (head != null) {
         head.prev = new_node;
     }
     head = new_node;
     return head;
 }
 NodeDLL curr = head;
 for (int i = 1; i < pos - 1 && curr != null; ++i) {
     curr = curr.next;
 }
 if (curr == null) {
     System.out.println("Posisi tidak ada");
     return head;
 }
 new_node.prev = curr;
 new_node.next = curr.next;
 curr.next = new_node;
 if (new_node.next != null) {
     new_node.next.prev = new_node;
 }
 return head;
}
//fungsi mencetak isi list
public static void printList(NodeDLL head) {
 NodeDLL curr = head;
 while (curr != null) {
     System.out.print(curr.data + " <-> ");
     curr = curr.next;
 }
 System.out.println();
}
public static void main (String [] args) {
	System.out.println("AhmadZahran");
	System.out.println("2411532004");
	// membuat dll 2 <->3<->5
	NodeDLL head = new NodeDLL(2);
	head.next = new NodeDLL(3);
	head.next.prev = head;
	head.next.next = new NodeDLL(5);
	head.next.next.prev = head.next;
	//cetak DLL awal
	System.out.println("DLL Awal: ");
	printList(head);
	head = insertBegin(head, 1);
	System.out.print("Simpul1 tambah diawal: ");
	printList(head);
	head = insertBegin(head, 6);
	System.out.print("Simpul 6 tambah diakhir: ");
	int data = 6;
	head = insertEnd(head,data);
	printList(head);
	System.out.println("tambah node 4 di posisi 4: ");
	int data2 = 4;
	int pos = 4;
	head = insertAtPosition(head, pos, data2);
	printList(head);
	}
}

