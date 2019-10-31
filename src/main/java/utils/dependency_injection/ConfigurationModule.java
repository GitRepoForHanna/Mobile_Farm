package utils.dependency_injection;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import steps.*;

public class ConfigurationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BaseEmulatorPageSteps.class).in(Singleton.class);
        bind(HomePageSteps.class).in(Singleton.class);
        bind(NoteTypePopupSteps.class).in(Singleton.class);
        bind(NotePageSteps.class).in(Singleton.class);
        bind(EditNotePageSteps.class).in(Singleton.class);
    }
}
