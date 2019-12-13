package turntabl.io.stories.models;

public class Reader {
    private String reader_name;
    private String reader_email;
    private Session session_info;

    public Reader() {
    }

    public Reader(String reader_name, String reader_email, Session session_info) {
        this.reader_name = reader_name;
        this.reader_email = reader_email;
        this.session_info = session_info;
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

    public Session getSession_info() {
        return session_info;
    }

    public void setSession_info(Session session_info) {
        this.session_info = session_info;
    }

    @Override
    public String toString() {
        return "Reader{" +
                ", reader_name='" + reader_name + '\'' +
                ", reader_email='" + reader_email + '\'' +
                ", session_info=" + session_info +
                '}';
    }
}