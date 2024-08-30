package tech.joelf.ms_credit_assessor.models;

public class ClientData {
    private Long id;
    private String name;

    public ClientData() {
    }

    public ClientData(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
