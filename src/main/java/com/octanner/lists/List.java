package com.octanner.lists;

/**
 * Implementation of a linear singly-linked list.
 * This list consists of a number of data elements in which each data element has a next pointer or next reference (the link) to the element that follows.
 * The last element in the list has an empty or null link.
 * Allows to store null elements
 */
public class List {

    private Node head;
    private int size;

    /**
     * Construct empty list
     */
    public List() {}

    /**
     * Construct list with given elements
     * @param elements list elements
     */
    public List(Object... elements) {
       for (Object element : elements) {
           add(element);
       }
    }

   /**
     * Returns the element at the specified position in this list.
     * @param index = index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public Object get(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("Illegal index value");
        Node node = head;
        for (int i = 0; i < size; i++) {
           if (i == index) return node.value;
           node = node.linkedNode;
        }
        return null;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Appends the specified element to the end of this list.
     * @param value element to be appended to this list
     * @return the instance of the list
     */
    public List add(Object value) {
        head = new Node(head, value);
        size++;
        return this;
    }

    /**
     * Removes the element at the specified position in this list (optional operation).
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public Object remove(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("Illegal index value");
        Node prevNode = null;
        Node thisNode = head;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                if (prevNode != null)
                    prevNode.linkedNode = thisNode.linkedNode;
                else
                    head = thisNode.linkedNode;
                size--;
                return thisNode.value;
            }
            prevNode = thisNode;
            thisNode = thisNode.linkedNode;
        }
        return null;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int indexOf(Object o) {
        if (o == null) return -1;
        Node node = head;
        for (int i = 0; i < size; i++) {
           if (node.value != null && node.value.equals(o)) {
              return i;
           }
            node = node.linkedNode;
        }
        return -1;
    }

    /**
     * Functional transformation of the list with using the function
     * @param f function that will be applied to each element
     * @return new list after transformation
     */
    public List map(Function f) {
        List newList = new List();
        for (int i = 0; i < size; i++) {
           newList.add(f.apply(this.get(i)));
        }
        return newList;
    }

    /**
     * String representation of the list
     * Example: new List(1,2,3).toString() should produce {3,2,1}
     * @return that represents the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node node = head;
        for (int i = 0; i < size; i++) {
            sb.append(node.value);
            if (i != size - 1) {
                sb.append(",");
            }
            node = node.linkedNode;
        }
        return sb.append("}").toString();
    }

    /**
     * Implementation that simplifies testing
     * Two lists are equals if they have the same number of elements and all elements are equals
     * @param other list to compare
     * @return true if lists are equals, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || (!(other instanceof List)))
            return false;
        List otherList = (List) other;
        if (otherList.size != this.size)
            return false;
        for (int i = 0; i < size; i++) {
            Object otherElement = otherList.get(i);
            Object thisElement = this.get(i);
            if (otherElement == null || thisElement == null)
               return false;
            if (!otherElement.equals(thisElement)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Hash Code implementation
     * @todo This should not be used as an example
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        for (int i = 0; i < size; i++) {
            if (this.get(i) != null) hashCode += this.get(i).hashCode();
        }
        return hashCode;
    }
}
