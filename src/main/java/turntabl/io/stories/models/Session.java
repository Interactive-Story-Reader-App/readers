package turntabl.io.stories.models;

public class Session {
    private String story_id;
    private String chapter_id;

    public Session() {
    }

    public Session(String story_id, String chapter_id) {
        this.story_id = story_id;
        this.chapter_id = chapter_id;
    }

    public String getStory_id() {
        return story_id;
    }

    public void setStory_id(String story_id) {
        this.story_id = story_id;
    }

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }
}
