package g54720.utils;

import java.util.Objects;

public class Dto<K> {
    protected K key;

    protected Dto(K key){
        if(key==null){
            throw new IllegalArgumentException("clé absente ");
        }
        this.key=key;
    }
    public K getKey(){
        return key;
    }

    @Override
    public int hashCode() {
        int hash =9;
        hash=55*hash + Objects.hashCode(this.key);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dto<?> dto = (Dto<?>) o;
        return Objects.equals(this.key, dto.key);
    }
}
