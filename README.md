
Architecture Overview:

    For the UI layer the app follows the MVVM pattern, relying on the android data binding for the binding part. The custom BindingAdapters are defined in the utils package Bindings.java class.

Domain and dependencies:

    The core package contains the contracts, models and repositories used throughout the app. The code aims to be as SOLID as possible so dependency inversion is applied all over and there might be more interfaces than some would like. The DependencyLocator static method collection acts as a compile-time service locator/ supplier of dependencies for the entire app, to allow for a proper DI solution to be applied, but also quick dependency toggling during development with mocks at different layers.

ProjectMVVM:

    ProjectListViewModel is the view model for the container of the collection of project items. It is bound to the activity_project_list.xml. When it receives the arguments in the onViewCreated callback it gets the projects (through the ProjectListModel).
    The ProjectListActivity acts as the ProjectListView, but also the Navigator (knows how to go to the project detail page). It initializes the view model, the recyclerview and the adapter.
    The single ProjectViewModel is responsible for its own presentation and is currently just a wrapper for the domain model that navigates to its own detail.

Network:

    The network package contains the Retrofit API definition and network models. The basic auth header data is hardcoded for this use case, it is added on each request through an interceptor on the OkHttp client.

Testing:

    The app has unit tests only for now. The coverage is basic but so is the app.