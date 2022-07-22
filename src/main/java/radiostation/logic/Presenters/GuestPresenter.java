package radiostation.logic.Presenters;

public class GuestPresenter extends Presenter {
    private CurriculumVitae cv;

    public GuestPresenter(String name, CurriculumVitae cv) {
        super(name);
        this.cv = cv;
    }


}
