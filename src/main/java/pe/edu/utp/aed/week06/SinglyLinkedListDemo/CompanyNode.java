package pe.edu.utp.aed.week06.SinglyLinkedListDemo;

public class CompanyNode {
    private Company company;
    private CompanyNode next;

    public CompanyNode(String companyName, String CEOName, int sinceYear) {
        company = new Company(companyName, CEOName, sinceYear);
        next = null;
    }

    public Company getCompany() {
        return company;
    }

    public CompanyNode getNext() {
        return next;
    }

    public void setNext(CompanyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return company.toString();
    }
}
