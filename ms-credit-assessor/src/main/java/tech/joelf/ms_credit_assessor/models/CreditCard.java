package tech.joelf.ms_credit_assessor.models;

public class CreditCard {
    private Long id;
    private String name;
    private String flag;
    private Long limitBasic;

    public CreditCard() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public Long getLimitBasic() {
        return limitBasic;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setLimitBasic(Long limitBasic) {
        this.limitBasic = limitBasic;
    }
}
