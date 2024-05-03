import Responses.Response;

public interface IQueries {
    Response insert(String query) throws Exception;
    Response select(String query) throws Exception;
    Response update(String query) throws Exception;
    Response delete(String query) throws Exception;
}