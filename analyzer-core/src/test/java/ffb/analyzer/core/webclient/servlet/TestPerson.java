package ffb.analyzer.core.webclient.servlet;

public class TestPerson {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof TestPerson)) {
            return false;
        }

        TestPerson p = (TestPerson) o;

        if (!p.getFirstName().equalsIgnoreCase(this.getFirstName())) {
            return false;
        }

        return p.getLastName().equalsIgnoreCase(this.getLastName());
    }
}
