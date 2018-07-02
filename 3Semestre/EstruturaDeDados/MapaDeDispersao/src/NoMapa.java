/**
 * @author Vinícius Luis da Silva
 */
public class NoMapa<T> {
    
    private int chave;
    private T info;

    public NoMapa(int chave) {
        this.chave = chave;
    }
    
    public NoMapa(int chave, T info) {
        this.chave = chave;
        this.info = info;
    }
    
    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NoMapa<?> other = (NoMapa<?>) obj;
        if (this.chave != other.chave) {
            return false;
        }
        return true;
    }
    
}
