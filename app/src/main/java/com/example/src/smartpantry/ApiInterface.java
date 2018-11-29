package com.example.src.smartpantry;

import com.example.src.smartpantry.pojos.AllocationPojo;
import com.example.src.smartpantry.pojos.Caterer;
import com.example.src.smartpantry.pojos.Distributor;
import com.example.src.smartpantry.pojos.Manager;
import com.example.src.smartpantry.pojos.Product;
import com.example.src.smartpantry.pojos.ProductBeverage;
import com.example.src.smartpantry.pojos.ProductFruit;
import com.example.src.smartpantry.pojos.ProductGrain;
import com.example.src.smartpantry.pojos.ProductMilk;
import com.example.src.smartpantry.pojos.ProductNon;
import com.example.src.smartpantry.pojos.ProductOil;
import com.example.src.smartpantry.pojos.ProductVegetable;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("loginmanager.php")  //ok
    Call<List<Manager>> doLoginManager();
    @GET("logindis.php") //ok
    Call<List<Distributor>> doLoginDistributor();
    @GET("logincatr.php") //ok
    Call<List<Caterer>> doLoginCaterer();

    @GET("productdetail1.php") //ok
    Call<List<Product>> getListProduct();
    @GET("managerdetail.php") //ok
    Call<List<Manager>> getListManager();
    @GET("distributordetail.php") //ok
    Call<List<Distributor>> getListDistributor();
    @GET("catererdetail.php") //ok
    Call<List<Caterer>> getListCaterer();

    @GET("productfruit.php")
    Call<List<ProductFruit>>getFruitList();

    @GET("productveges.php")
    Call<List<ProductVegetable>>getVegetableList();

    @GET("productgrain.php")
    Call<List<ProductGrain>>getGrainList();

    @GET("productmilk.php")
    Call<List<ProductMilk>>getMilkProductList();

    @GET("productbeverages.php")
    Call<List<ProductBeverage>>getBeveragList();

    @GET("productnonveg.php")
    Call<List<ProductNon>>getNonList();

    @GET("productoil.php")
    Call<List<ProductOil>>getOilProductList();



    @GET("manager.php")
    Call<Manager> insertUser(@Query("manager_firstName") String manager_firstName,
                          @Query("manager_lastName") String manager_lastName,
                          @Query("manager_emailId") String manager_emailId,
                          @Query("manager_pass") String manager_pass,
                          @Query("manager_contact") String manager_contact,
                          @Query("manager_city")String manager_city,
                          @Query("manager_state")String manager_state,
                          @Query("manager_country")String manager_country);

    @GET("distributor.php")
    Call<Distributor> insertUser2(@Query("distributor_firstName") String distributor_firstName,
                             @Query("distributor_lastName") String distributor_lastName,
                             @Query("distributor_emailId") String distributor_emailId,
                             @Query("distributor_pass") String distributor_pass,
                             @Query("distributor_contact") String distributor_contact,
                             @Query("distributor_city")String distributor_city,
                             @Query("distributor_state")String distributor_state,
                             @Query("distributor_country")String distributor_country);

    @GET("caterer.php")
    Call<Caterer> insertUser3(@Query("caterer_firstName") String caterer_firstName,
                             @Query("caterer_lastName") String caterer_lastName,
                             @Query("caterer_emailId") String caterer_emailId,
                             @Query("caterer_pass") String caterer_pass,
                             @Query("caterer_contact") String caterer_contact,
                             @Query("caterer_city")String caterer_city,
                             @Query("caterer_state")String caterer_state,
                             @Query("caterer_country")String caterer_country);

    @GET("managerresetpass.php")
    Call<List<Manager>> doReset(@Query("manager_emailId")String manager_emailId,
                             @Query("manager_pass")String manager_pass);
    @GET("distributorresetpass.php")
    Call<List<Distributor>> doReset2(@Query("distributor_emailId")String distributor_emailId,
                                    @Query("distributor_pass")String distributor_pass);

    @GET("cateresetpass.php")
    Call<List<Caterer>> doReset3(@Query("caterer_emailId")String caterer_emailId,
                                    @Query("caterer_pass")String caterer_pass);


    @FormUrlEncoded
    @GET("devicesinsert.php")
    Call<Product> insertProductData(@Field("product_img") String product_img,
                                @Field("product_name") String product_name,
                                @Field("product_quantity") String product_quantity );

    @GET("allocationdetail.php")
    Call<List<AllocationPojo>> getAlloc();

    @GET("allocation.php")
    Call<AllocationPojo> saveAllocation(  //@Query("distributor_emailId") String distributor_emailId,
                                        @Query("distributor_firstName")String distributor_firstName,
                                        @Query("distributor_contact")String distributor_contact,
                                        @Query("food_category")String food_category);

    Call<AllocationPojo>updateallocation(@Query("distributor_emailId")String distributor_emailId,
                                         @Query("food_category")String food_category);

}
