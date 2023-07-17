package ug.co.absa.notify.utility;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ug.co.absa.notify.domain.models.*;


public interface ApiInterface {

    @POST("SendMail")
    @Headers("accept: application/json")
    Call<EmailApiResponse> sendMail(@Body MailApiRequest mailApiRequest);

    @POST("getAccountDetails")
    @Headers("accept: application/json")
    Call<ValidationResponse> getCustomerEmail(@Body AccountRequest accountRequest);

}
