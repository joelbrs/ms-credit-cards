package tech.joelf.ms_credit_assessor.dtos;

public class DataAssessmentRequest {
    private String cpf;
    private Long income;

    public DataAssessmentRequest(String cpf, Long income) {
        this.cpf = cpf;
        this.income = income;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getIncome() {
        return income;
    }
}
