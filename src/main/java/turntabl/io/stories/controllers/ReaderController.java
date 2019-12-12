package turntabl.io.stories.controllers;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.cloudant.client.api.query.JsonIndex;
import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;
import com.cloudant.client.api.query.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import turntabl.io.stories.models.ReadersTO;

import java.io.IOException;
import java.util.List;

import static com.cloudant.client.api.query.Expression.*;

@RestController
public class ReaderController {

    @Autowired
    private Database db;

    @CrossOrigin
    @PostMapping("/api/v1/readers")
    public void addNewReaders(@RequestBody ReadersTO reader){
        db.save(reader);
    }

    @CrossOrigin
    @GetMapping("/api/v1/readers/")
    public List<ReadersTO> getReaders() throws IOException{
        List<ReadersTO> allreaders = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(ReadersTO.class);
        return allreaders;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/v1/readers/{id}", method = RequestMethod.GET)
    public ReadersTO searchReaderById(@PathVariable("id") String id){
        return db.find(ReadersTO.class, id);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/v1/readers/{id}", method = RequestMethod.PATCH)
    public void updateReader(@RequestBody ReadersTO readerUpdate, @PathVariable("id") String id){
        ReadersTO reader = db.find(ReadersTO.class, id);

        reader.setReader_id(readerUpdate.getReader_id());
        reader.setReader_name(readerUpdate.getReader_name());
        reader.setReader_email(readerUpdate.getReader_email());

        Response response = db.update(reader);
    }

    @CrossOrigin
    @DeleteMapping("/api/v1/stories/{id}")
    public void deleteReader(@PathVariable("id") String id){
        ReadersTO reader = db.find(ReadersTO.class, id);
        Response response = db.remove(reader);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/v1/readers/search", method = RequestMethod.GET)
    public QueryResult<ReadersTO> searchForReaderByName(@RequestParam(value = "name") String name){
        db.createIndex(JsonIndex.builder().asc("reader_name").definition());

        QueryResult<ReadersTO> readers = db.query(new QueryBuilder(
                in("reader_name", name)).sort(Sort.desc("story_name")).build(), ReadersTO.class);
        return readers;
    }

}
