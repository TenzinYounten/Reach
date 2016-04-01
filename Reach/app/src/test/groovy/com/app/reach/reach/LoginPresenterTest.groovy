package com.app.reach.reach
import com.app.reach.ReachEndPoint.ReachEndpointInterface
import com.app.reach.model.AunthenticatedUser
import com.app.reach.reach.Login.*
import org.greenrobot.eventbus.EventBus
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robospock.internal.GradleRoboSputnik
import spock.lang.Specification
import spock.lang.Unroll

@RunWith(GradleRoboSputnik)
@Config(manifest = Config.NONE, constants = BuildConfig)
public class LoginPresenterTest extends Specification {

    private LoginView view = Mock(LoginView);
    private LoginService service = Mock(LoginService)
    private LoginPresenter presenter = new LoginPresenter(view, service);

    private AunthenticatedUser user = Mock(AunthenticatedUser)
    private SuccessfulLoginEvent successfulLoginEvent = Mock(SuccessfulLoginEvent)
    private UnsuccessfulLoginEvent unsuccessfulLoginEvent = Mock(UnsuccessfulLoginEvent)
    private EventBus bus = Mock(EventBus)

    private ReachEndpointInterface reachEndpointInterface = Mock(ReachEndpointInterface)

    //private loginActivity = Mock(LoginActivity)

    //def usernameView = loginActivity.findViewById(R.id.username);
    //def passwordView = loginActivity.findViewById(R.id.password)

    /*def "activity should be initialized"() {
        when:
            def mainActivity = Robolectric.buildActivity(LoginActivity).create().get()

        then:
            mainActivity != null
    }*/

    @Unroll
    def "On invalid username error message should be displayed"() {
        given:
        view.getUsername() >> username

        when:
        def result = presenter.validateUsername(view.getUsername())

        then:
        result == extectedResult

        and:
        1 * view.showUsernameError(R.string.invalid_username)

        where:
        username | extectedResult
        ""       | false
        null     | false
    }

    @Unroll
    def "On valid username no error message should be displayed"() {
        given:
        view.getUsername() >> username

        when:
        def result = presenter.validateUsername(view.getUsername())

        then:
        result == expectedResult
        and:
        0 * view.showUsernameError(R.string.invalid_username)

        where:
        username   | expectedResult
        "someuser" | true
    }

    @Unroll
    def "On invalid password error message should be displayed"() {
        given:
        view.getPassword() >> password

        when:
        def result = presenter.validatePassword(view.getPassword())

        then:
        result == extectedResult
        and:
        1 * view.showPasswordError(R.string.invalid_password)

        where:
        password | extectedResult
        ""       | false
        null     | false
    }

    @Unroll
    def "On valid password no error message should be displayed"() {
        given:
        view.getPassword() >> password

        when:
        def result = presenter.validatePassword(view.getPassword())

        then:
        result == extectedResult

        and:
        0 * view.showPasswordError(R.string.invalid_password)

        where:
        password   | extectedResult
        "password" | true
    }

    @Unroll
    def "should call login service when login is called"() {
        given:
        view.getUsername() >> username
        view.getPassword() >> password
        LoginData data = new LoginData(username, password)

        when:
        presenter.login(username, password)

        then:
        //1 * reachEndpointInterface.doLogin(data)
        1 * service.login(username, password)

        where:
        username    |   password
        "username"  |   "password"


    }

    @Unroll
    def "should call ReachEndpointInterface api when login is called"() {
        given:
        view.getUsername() >> username
        view.getPassword() >> password
        LoginData data = new LoginData(username, password)

        when:
        service.login(username, password)

        then:
        1 * reachEndpointInterface.doLogin(LoginData(username, password))


        where:
        username    |   password
        "username"  |   "password"


    }

    @Unroll
    def "If login service is called no error message should be displayed"() {

        when:
        def result = presenter.login(username, password)
        //and:

        //def mainActivity = new Context.startActivity(new Intent(context, MainActivity.class))

        then:
        result == expectedResult

        where:
        username   | password   | expectedResult
        "username" | "password" | true

    }

   /* @Unroll
    def "On successful login" () {
        given:


            user.username = "admin"
            user.accessToken = "accesstoken"
            user.expiresIn = 3600
            user.refreshToken = "refreshtoken"
            user.roles = "admin"
            user.tokenType = "token"
            successfulLoginEvent(user)

       when:
            bus.post(successfulLoginEvent)

       then:
            1* view.startMainActivity()

    }

    @Unroll
    def "On unsuccessful login due to wrong credentials"() {
        given:

        user = null

        successfulLoginEvent(user)

        when:
        bus.post(successfulLoginEvent)

        then:
        1* view.showLoginError(R.string.invalid_login)

    }

    @Unroll
    def "On unsuccessful login due to network failiure"() {

      *//*  service.login("username", "password")
        Call<AunthenticatedUser> call = reachEndpointInterface.doLogin(loginData)
        call.enqueue() << *//*



    }*/
}
