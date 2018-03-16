package dilan.dublinbike.classes;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//DILAN TOLLEN     16357

public interface DublinBikeService {

    @GET("stations?contract=Dublin&apiKey=5bb43f341db582155668bdd1dd629688c8f76635")
    Call<List<Station>> getStations();
}

