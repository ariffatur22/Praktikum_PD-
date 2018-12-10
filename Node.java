/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asuransi;

/**
 *
 * @author Scarlet RaiN
 */
public class Node {
    Node next;
    String[] data;

    Node() {
        next = null;
        data = null;
    }

    Node(String[] Data) {
        next = null;
        data = Data;
    }

    Node(String[] Data, Node Next) {
        next = Next;
        data = Data;
    }
}
