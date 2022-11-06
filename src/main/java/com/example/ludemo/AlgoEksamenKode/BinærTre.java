package com.example.ludemo.AlgoEksamenKode;

public class BinærTre <E>{

    protected BinærNode<E> rot;
    class BinærNode<E> {
        BinærNode<E> venstre, høyre;
        E element;
    }

    public void speil(){
        speil(rot);
    }
    public void speil(BinærNode<E> node){
        if(node==null) return;
        speil(node.venstre);
        speil(node.høyre);
        BinærNode<E> tmp = node.venstre;
        node.venstre = node.høyre;
        node.høyre = tmp;
    }

    public BinærTre<E> speilKopi(){
        BinærTre<E> bt = new BinærTre<>();

        /* Rekursiv løsning */
        bt.rot = rekSpeilKopi(new BinærNode<>(), rot);

        return bt;
    }

    private BinærNode<E> rekSpeilKopi(BinærNode<E> current, BinærNode<E> original){
        if(original==null)return null;
        current.element = original.element;
        current.venstre = rekSpeilKopi(new BinærNode<>(), original.høyre);
        current.høyre = rekSpeilKopi(new BinærNode<>(), original.venstre);
        return current;
    }
}
