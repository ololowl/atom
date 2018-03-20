package ru.atom.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class CustomLinkedList<E> implements List<E> {
    private int len;
    private ListNode<E> first;
    private ListNode<E> last;

    public CustomLinkedList() {
        this.len = 0;
        this.first = new ListNode<E>();
        this.last = this.first;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public boolean contains(Object o) {
        E elem = (E) o;
        for (ListNode<E> node = this.first; node != this.last; node = node.getNext()) {
            if (elem == node.getValue()) {
                return true;
            }
        }
        if (this.last.getValue() == o) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        ListNode<E> obj = new ListNode<E>(e);
        this.last.setNext(obj);
        this.last.setNextPrev(this.last);
        this.last = this.last.getNext();
        return true;
    }

    @Override
    public boolean remove(Object o) {
        E elem = (E) o;
        if (this.last.getValue() == o) {
            if (this.last.getPrev() != null) {
                this.last = this.last.getPrev();
                this.last.setNextPrev(null);
                this.last.setNext(null);
            } else {
                this.last = null;
                this.first = null;
            }
            return true;
        }
        if (this.first.getValue() == o) {
            this.first = this.first.getNext();
            this.first.setPrevNext(null);
            this.first.setPrev(null);
            return true;
        }
        ListNode<E> globalNext = this.first;
        for (ListNode<E> node = this.first.getNext(); node != this.last; node = globalNext) {
            if (elem == node.getValue()) {
                node.setPrevNext(node.getNext());
                node.setNextPrev(node.getPrev());
                node.setPrev(null);
                globalNext = node.getNext();
                node.setNext(null);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (ListNode<E> node = this.first; node != this.last; ) {
            this.first = node.getNext();
            node = node.getNext();
            node.setPrevNext(null);
            node.setPrev(null);
        }
        this.first = null;
        this.last = null;
    }

    @Override
    public E get(int index) {
        if (index >= this.size()) {
            return null;
        }
        ListNode<E> node = this.first;
        for (int i = 0; i < index; ++i) {
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public int indexOf(Object o) {
        E elem = (E) o;
        int idx = 0;
        for (ListNode<E> node = this.first; node != this.last; node = node.getNext()) {
            if (elem == node.getValue()) {
                return idx;
            }
            ++idx;
        }
        return -1;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }


    /*
      !!! Implement methods below Only if you know what you are doing !!!
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return true;
            }
        }
        return true;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public void add(int index, E element) {
    }

    /**
     * Do not implement
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * Do not implement
     */
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * Do not implement
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public E set(int index, E element) {
        return null;
    }
}
