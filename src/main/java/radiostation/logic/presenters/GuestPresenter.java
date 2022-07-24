package radiostation.logic.presenters;

public class GuestPresenter extends Presenter {
    private final CurriculumVitae cv;

    public GuestPresenter(String name, CurriculumVitae cv) {
        super(name);
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "GuestPresenter{" +
                "name='" + name + '\'' +
                ", cv=" + cv +
                //", broadcastLists=" + broadcastLists +
                '}';
    }
}
