package tech.joelf.ms_card.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tech.joelf.ms_card.enums.FlagCard;

@Entity
@Table(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private FlagCard flag;
    private BigDecimal limitBasic;
    private BigDecimal income;

    public Card() {
    }

    public Card(Long id, String name, FlagCard flag, BigDecimal limitBasic, BigDecimal income) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.limitBasic = limitBasic;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlagCard getFlag() {
        return flag;
    }

    public void setFlag(FlagCard flag) {
        this.flag = flag;
    }

    public BigDecimal getLimitBasic() {
        return limitBasic;
    }

    public void setLimitBasic(BigDecimal limitBasic) {
        this.limitBasic = limitBasic;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
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
        Card other = (Card) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
