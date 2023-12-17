package actions;

/**
 * Actions indicate what should be done when, for example, the button is clicked.
 * They don't do anything on their own,
 * but are used to communicate between {@link views.BaseScreen screen (view)},
 * {@link controllers.BaseController controller} and {@link models.BaseModel model}.
 */
public enum Actions {
    CHANGE_TEXT, TO_UPPERCASE,
}
