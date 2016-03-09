package com.app.reach.reach

import com.app.reach.reach.Login.LoginPresenter
import com.app.reach.reach.Login.LoginService
import com.app.reach.reach.Login.LoginView
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robospock.internal.GradleRoboSputnik
import spock.lang.Specification
import spock.lang.Unroll

@RunWith(GradleRoboSputnik)
@Config(manifest = Config.NONE, constants = BuildConfig)
public class LoginPresenterTest extends Specification {

    private LoginView view = Mock(LoginView);
    private LoginService service = Mock(LoginService);
    private LoginPresenter presenter = new LoginPresenter(view, service);
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
        result == extectedResult
        and:
        0 * view.showUsernameError(R.string.invalid_username)

        where:
        username   | extectedResult
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
    def "On invalid login error message should be displayed"() {
        given:
        view.getUsername() >> username
        view.getPassword() >> password

        when:
        def result = presenter.login(username, password)

        then:
        result == extectedResult
        and:
        1 * view.showLoginError(R.string.invalid_login)

        where:
        username   | password   | extectedResult
        ""         | ""         | false
       // "username" | "password" | false
    }

    @Unroll
    def "On valid login no error message should be displayed"() {
        given:
        view.getUsername() >> username
        view.getPassword() >> password
        service.login(_, _) >> true

        when:
        def result = presenter.login(username, password)
        //and:

        //def mainActivity = new Context.startActivity(new Intent(context, MainActivity.class))

        then:
        1* view.startMainActivity()

        where:
        username   | password   | extectedResult
        "jack"     | "jack"     | true
    }

    /* @Unroll
     def "should enable login button"() {
         given:
         passwordView = passwd
         usernameView = username

         when:
         presenter.onLoginClicked()

         then:
         loginActivity.showUsernameError(R.string.invalid_username)
         loginActivity.showPasswordError(R.string.invalid_password)

         where:
         passwd   | username
         null     | "Alina"
         "Oksana" | "Pavel"
         "Maciej" | ""
         null     | ""
     }*/

    /*def "shouldShowErrorMessageWhenPasswordIsEmpty"() {
        given:
            view.getUsername()
        when:
            presenter.onLoginClicked()
        then:
            view.showUsernameError(R.string.invalid_username)
        where:
            username | password
             ""     | ""
             ""   | "nkadj"

    }*/


}

/**
 * Created by tenzin on 2/3/16.
 */
//@RunWith(MockitoJUnitRunner.class)
//public class LoginPresenterTest {
//    @Mock
//    private LoginView view;
//    @Mock
//    private LoginService service;
//    private LoginPresenter presenter;
//
//    @Before
//    public void setUp() throws Exception {
//        presenter = new LoginPresenter(view, service);
//
//    }
//
//    @Test
//    public void shouldshowerrormessageWhenUserNameIsEmpty() throws Exception {
//        when(view.getUsername()).thenReturn("");
//        presenter.onLoginClicked();
//        verify(view).showUsernameError(R.string.invalid_username);
//
//    }
//
//    @Test
//    public void shouldshowerrormessageWhenPasswordIsEmpty() throws Exception {
//        when(view.getUsername()).thenReturn("james");
//        when(view.getPassword()).thenReturn("");
//        presenter.onLoginClicked();
//        verify(view).showPasswordError(R.string.invalid_password);
//
//    }
//
//    @Test
//    public void startWhenUsernameAndPasswordAreCorrect() throws Exception {
//        when(view.getUsername()).thenReturn("james");
//        when(view.getPassword()).thenReturn("bond");
//        when(service.login("james", "bond")).thenReturn(true);
//        presenter.onLoginClicked();
//        verify(view).startMainActivity();
//    }
//
//    @Test
//    public void shouldshowloginerroronwrongusernamepassword() throws Exception {
//        when(view.getUsername()).thenReturn("james");
//        when(view.getPassword()).thenReturn("bond");
//        when(service.login("james", "bond")).thenReturn(false);
//        presenter.onLoginClicked();
//        verify(view).showLoginError(R.string.invalid_login);
//    }
//}
