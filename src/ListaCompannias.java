import java.util.ArrayList;
import java.util.List;

public class ListaCompannias {
    private List<Compannia> compannias;

    public ListaCompannias() {
        compannias = new ArrayList<>();
    }

    public List<Compannia> getCompannias() {
        return compannias;
    }

    public void setCompannias(List<Compannia> compannias) {
        this.compannias = compannias;
    }

    public void agregarCompannia(Compannia compannia) {
        compannias.add(compannia);
    }
}
