package turntabl.io.stories.dao;

import turntabl.io.stories.models.ReadersTO;

import javax.validation.constraints.Max;
import java.util.List;

public interface ReadersDAO {
    public void registerNewReader(ReadersTO reader);
    public void updateReader(Integer id, ReadersTO reader);
    public List<ReadersTO> getAllReaders();
    public List<ReadersTO> getReaderByName(String name);
    public void deleteReader(Integer id);
    public ReadersTO getReaderById(Integer id);
}
