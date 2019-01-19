package response;


public class ApiResponse {
    boolean status ;
    Message msg;

    public boolean isStatus() {
        return status;
    }

    public Message getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status=" + status +
                ", msg=" + msg +
                '}';
    }
}
