package archive.accesses;

import archive.accesses.HideMe.Technologies;

public class Robot extends Technologies {

    public Robot (String name) {
        super(name);
    }

    @Override
    public void whatCanDo() {
        super.whatCanDo();
    }

    @Override
    public Robot getTech() {
        return (Robot) super.getTech();
    }

    @Override
    public void setTech(Technologies tech) {
        this.tech = tech;
    }

    public Robot (String name, Robot robot) {
        super(name, robot);
    }
}
