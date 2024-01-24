package PadroesDeProjetos.Fabrica;

public class Customer {
    private String gradeRequest;
    private Boolean temComtratoCompania;

    public Customer(String gradeRequest, Boolean temComtratoCompania) {
        this.gradeRequest = gradeRequest;
        this.temComtratoCompania = temComtratoCompania;
    }

    public String getGradeRequest() {
        return gradeRequest;
    }

    public Boolean getTemComtratoCompania() {
        return temComtratoCompania;
    }
}
