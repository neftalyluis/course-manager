import course.manager.PersonPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    personPasswordEncoderListener(PersonPasswordEncoderListener, ref('hibernateDatastore'))
}
