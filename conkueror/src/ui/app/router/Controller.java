package ui.app.router;

import ui.app.router.Route;
import ui.app.router.Router;

import java.lang.annotation.*;

/**
 * <p>Registers a controller class to the router.</p>
 * <ul>
 *      <li>Use {@link Route} to specify the route for the controller.</li>
 * </ul>
 *
 * @since 0.4.0
 * @see Router
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Controller {
    Route at();
}