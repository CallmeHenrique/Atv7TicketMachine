package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        papeisMoeda[5] = valor % 100;
        valor -= papeisMoeda[5] * 100;
        papeisMoeda[4] = valor % 50;
        valor -= papeisMoeda[4] * 50;
        papeisMoeda[3] = valor % 20;
        valor -= papeisMoeda[3] * 20;
        papeisMoeda[2] = valor % 10;
        valor -= papeisMoeda[2] * 10;
        papeisMoeda[1] = valor % 5;
        valor -= papeisMoeda[1] * 5;
        papeisMoeda[0] = valor % 2;
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i--) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            PapelMoeda retorno = next();
        }
    }
}
