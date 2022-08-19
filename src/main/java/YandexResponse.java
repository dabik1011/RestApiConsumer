import java.util.List;

//этот класс будет соответсвовать структуре Json  объекта, респонс которого мы получаем
public class YandexResponse {
    private List<Translation> translations;

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }
}
