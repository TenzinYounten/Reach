package com.app.reach.reach
import com.app.reach.reach.Login.SuccessfulLoginEvent
import com.app.reach.reach.Main.MainService
import com.app.reach.reach.Main.MainView
import org.greenrobot.eventbus.EventBus
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robospock.internal.GradleRoboSputnik
import spock.lang.Specification
/**
 * Created by tenzin on 18/3/16.
 */
@RunWith(GradleRoboSputnik)
@Config(manifest = Config.NONE, constants = BuildConfig)
class MainPresenterTest extends Specification{
    private MainView mainView = Mock(MainView)
    private MainService mainService = Mock(MainService)
    private SuccessfulLoginEvent event = Mock(SuccessfulLoginEvent)
    private EventBus bus = Mock(EventBus.getDefault())

/*@Unroll
    def "if use is already signed in keep sign-in button invisible" () {
        given:
            bus.getStickyEvent(SuccessfulLoginEvent.class) >>
        when:
            event = bus.getStickyEvent(SuccessfulLoginEvent.class)

    }*/
}
