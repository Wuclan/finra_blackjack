package app;
import java.util.List; 

public abstract class AbstractPlayer implements Player {

    private String id;

    public AbstractPlayer(String id) {
        this.id = id;
    }

    @Override
    abstract public boolean isHuman();

    @Override
    abstract public boolean hit(List<BlackJackCard> hand);

    @Override
    public String getID() {
        return id;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractPlayer other = (AbstractPlayer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}