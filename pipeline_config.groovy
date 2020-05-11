pipeline_template = 'java'
skip_default_checkout = true

libraries{
    gradle
    approve {
        branch_conditional = "master"
    }
    hola_mundo {
        branch_conditional = "master"
    }
}