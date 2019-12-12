package turntabl.io.stories.dao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import turntabl.io.stories.models.ReadersTO;

import java.util.List;

@Api
@RestController
public class ReadersDAOI implements ReadersDAO{

    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Register a new Reader")
    @Override
    @PostMapping("/api/v1/readers")
    public void registerNewReader(@RequestBody ReadersTO reader) {
        template.update("insert into readers(reader_id, reader_name, reader_email) values(?, ?, ?)",
                reader.getReader_id(), reader.getReader_name(), reader.getReader_email());
    }

    @CrossOrigin
    @ApiOperation("Update a reader")
    @Override
    @PutMapping("/api/v1/readers/{id}")
    public void updateReader(@PathVariable("id") Integer id, ReadersTO reader) {
            template.update("update readers set reader_name = ?, reader_email = ? where reader_id = ?",
                reader.getReader_name(), reader.getReader_email(), reader.getReader_id());
        //not working as expected
    }

    @CrossOrigin
    @ApiOperation("All readers")
    @Override
    @GetMapping("api/v1/readers")
    public List<ReadersTO> getAllReaders() {
        return template.query("select * from readers", new BeanPropertyRowMapper<ReadersTO>(ReadersTO.class));
    }

    @CrossOrigin
    @ApiOperation("search reader by name")
    @Override
    @GetMapping("api/v1/readers/search")
    public List<ReadersTO> getReaderByName(@RequestParam(value = "name") String name) {
        return this.template.query("select * from readers where reader_name like ?", new Object[]{name + "%"},
                new BeanPropertyRowMapper<ReadersTO>(ReadersTO.class));
    }

    @CrossOrigin
    @ApiOperation("Delete a reader")
    @Override
    @DeleteMapping("api/v1/readers/{id}")
    public void deleteReader(@PathVariable("id") Integer id) {
        this.template.update("delete from readers where reader_id = ?", id);
    }

    @CrossOrigin
    @ApiOperation("Get a reader by id")
    @Override
    @GetMapping("api/v1/readers/{id}")
    public ReadersTO getReaderById(@PathVariable("id") Integer id) {
        return (ReadersTO) template.query("select * from readers where reader_id = ?", new Object[]{id},
                new BeanPropertyRowMapper(ReadersTO.class));
    }
}
