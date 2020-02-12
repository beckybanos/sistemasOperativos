public class MemoriaCentral {

    private int free;
    private String[] pages;

    public MemoriaCentral(int size) {
        free = size;
        pages = new String[size];
    }

    public synchronized boolean checkPages(int reqPages) {
        return reqPages <= free;
    }

    public synchronized int[] setPages(int reqPages, String procName) {
        free -= reqPages;
        int[] res = new int[reqPages];
        int cont = 0;
        for (int i = 0; i < pages.length; i++) {
            if (cont == reqPages) {
                break;
            }
            if (pages[i] == null) {
                pages[i] = procName;
                res[cont] = i;
                cont++;
            }
        }
        return res;
    }

    public synchronized void freePages(String procName) {
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] != null && pages[i].equals(procName)) {
                free++;
                pages[i] = null;
            }
        }
    }

}
