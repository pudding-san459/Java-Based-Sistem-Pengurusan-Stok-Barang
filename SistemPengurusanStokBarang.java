package amali;

import java.util.Scanner;

public class SistemPengurusanStokBarang {
    
    // Nested class representing a node in the linked list
    class Node{
        String data;
        Node next;

        // Constructor to initialize a node with data
        public Node(String d){
            this.data=d;
            this.next=null;
        }
    }

    public Node head = null;
    public Node tail = null;

    // Method to add a new stock item to the linked list
    public void tambah(String data){
        
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to delete a stock item from the linked list based on position
    public void padam(int position){
        System.out.println("~~ Memadam Stok Barang Pada Kedudukan " + position + " ~~");

        if (head == null) {
            System.out.println("Tiada Stok Barang");
            return;
        } else if (position-1 == 0) {
            head = head.next;
            return;
        }
    
        Node current = head;
        Node prev = null;
    
        int i;
        for (i = 0; current != null && i < position - 1; i++) {
            prev = current;
            current = current.next;
        }
    
        if (current == null) {
            System.out.println("Tiada stok barang pada kedudukan yang ditetapkan");
        } else {
            prev.next = current.next;

            // Update tail pointer if the deleted item was the last one
            if (current.next == null) {
                tail = prev;
            }
        }
    }

    // Method to display all stock items in the linked list
    public void papar(){

        Node current = head;
        if(head == null){
            System.out.println("Tiada Stok Barang");
            return;
        }
        System.out.println("\nStok Barang: ");
        System.out.print("---------------------------");
        int i = 1;
        while (current != null) {
            System.out.println("\n" + i + ". " + current.data);
            current = current.next;
            i++;
        }
        System.out.println();
    }

    // Main method to execute the program
    public static void menu(){
        System.out.println("\n~~ Sistem Pengurusan Stok Barang ~~");
        System.out.println("1. Tambah Stok Barang");
        System.out.println("2. Padam Stok Barang");
        System.out.println("3. Papar Stoke Barang");
        System.out.println("4. Keluar Program");
        System.out.print("Menu Pilihan: ");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SistemPengurusanStokBarang newStok = new SistemPengurusanStokBarang();

        while (true) {
                menu();
            int menu = scan.nextInt();

            switch (menu) {
                case 1:

                    System.out.println("\n~~ Tambah Stok Barang ~~");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("\nNombor Siri Barang: ");
                        int siri = scan.nextInt();
                        System.out.print("Nama Barang: ");
                        String nama = scan.next();
                        System.out.print("Bilangan Stok: ");
                        int bil = scan.nextInt();

                        String toString = "Nombor Siri: " + siri + "\nNama Barang: " + nama + "\nBilang Stok: " + bil;

                        newStok.tambah(toString);
                    }
                   
                    break;

                case  2:
                    System.out.print("\nMasukkan Kedudukan Stok untuk Dipadam: ");
                    int pos = scan.nextInt();
                    newStok.padam(pos);
                    break;

                case 3: 
                    newStok.papar();
                    break;
            
                case 4:
                    System.out.println("\nProgram Dimatikan, Jumpa Lagi");
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}
