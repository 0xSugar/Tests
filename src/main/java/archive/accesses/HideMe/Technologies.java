package archive.accesses.HideMe;

public abstract class Technologies {
    protected String name;

    protected Technologies tech;

    protected Technologies(String name) {
        this.name = name;
    }

    protected Technologies(String name, Technologies tech) {
        this.name = name;
        this.tech = tech;
    }

    protected void whatCanDo() {
        if (tech != null) {
            System.out.printf("Я - %s, у меня находится - %s%n", name, tech);
        } else {
            System.out.printf("Я - %s, у меня никого нет%n", name);
        }
    }
    
    protected Technologies getTech() {
        return tech;
    }
    protected void setTech(Technologies tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return name;
    }
}
