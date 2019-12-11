package turntabl.io.stories.models;

public class ReadersTO {
    private int reader_id;
    private String reader_name;
    private String reader_email;

    public ReadersTO() {
    }

    public ReadersTO(int reader_id, String reader_name, String reader_email, int current_story, int chapter_id) {
        this.reader_id = reader_id;
        this.reader_name = reader_name;
        this.reader_email = reader_email;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }

    public String getReader_email() {
        return reader_email;
    }

    public void setReader_email(String reader_email) {
        this.reader_email = reader_email;
    }

    @Override
    public String toString() {
        return "ReadersTO{" +
                "reader_id=" + reader_id +
                ", reader_name='" + reader_name + '\'' +
                ", reader_email='" + reader_email + '\'' +
                '}';
    }
}

