package turntabl.io.stories.controllers;

import com.cloudant.client.api.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import turntabl.io.stories.models.Reader;

import java.io.IOException;
import java.util.List;

@RestController
public class ReaderController {

    @Autowired
    private Database db;

    @CrossOrigin
    @PostMapping("/api/v1/readers")
    public void addNewReaders(@RequestBody Reader reader){
        db.save(reader);
    }

    @CrossOrigin
    @GetMapping("/api/v1/readers")
    public List<Reader> getChapters() throws IOException {
        List<Reader> allReaders = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(Reader.class);
        return allReaders;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/v1/readers/{id}", method = RequestMethod.GET)
    public Reader searchReaderById(@PathVariable("id") String id){
        return db.find(Reader.class, id);
    }

}
