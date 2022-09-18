import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class code {
    // TAKE INPUT FOR LINKED LIST
    public static Node<Integer> takeInput() {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner sc = new Scanner(System.in);
        if (System.getProperty("ONLINE_JUDGE") == null) {
            try {
                System.setOut(new PrintStream(new FileOutputStream("output.txt")));
                sc = new Scanner(new File("input.txt"));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        int data = sc.nextInt();
        while (data != -1) {
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            data = sc.nextInt();
        }
        sc.close();
        return head;

    }

    // PRINT LINKED LIST
    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // INSERT A NODE
    public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
        Node<Integer> newNode = new Node<Integer>(data);
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        int i = 0;
        Node<Integer> temp = head;
        while (i < pos - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // DELETE A NODE
    public static Node<Integer> delete(Node<Integer> head, int pos) {
        Node<Integer> temp = head;
        int i = 0;
        if (pos == 0) {
            head = head.next;
            return head;
        }
        while (i < pos - 1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {

        // Your Code Starts Here
        Node<Integer> head = takeInput();
        head = delete(head, 4);
        print(head);
    }
}
