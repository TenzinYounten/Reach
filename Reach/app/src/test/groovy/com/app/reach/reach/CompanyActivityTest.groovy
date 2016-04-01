package com.app.reach.reach
import com.app.reach.ReachEndPoint.ReachEndpointInterface
import com.app.reach.model.Company
import com.app.reach.reach.Company.CompanyPresenter
import com.app.reach.reach.Company.CompanyService
import com.app.reach.reach.Company.CompanyView
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robospock.internal.GradleRoboSputnik
import retrofit2.Call
import retrofit2.Response
import spock.lang.Specification
import spock.lang.Unroll
/**
 * Created by tenzin on 18/3/16.
 */
@RunWith(GradleRoboSputnik)
@Config(manifest = Config.NONE, constants = BuildConfig)
class CompanyActivityTest extends Specification {
    CompanyService service = Mock(CompanyService)
    CompanyView view = Mock(CompanyView)
    CompanyPresenter presenter = Mock(CompanyPresenter)
    ReachEndpointInterface endpointInterface = Mock(ReachEndpointInterface)


    @Unroll
    def "should call reachEndpointInterface api when service is called" () {
        given:
        def loginResponse = Mock(Company)
        def retrofitResponse = new Response("url", 200, "", [], null)

        when:
        Call<List<Company>> call
        1 * endpointInterface.getCompanies()


    }


}
