node {
    download.set(true)
    version.set("18.12.1")
}

plugins {
    id("com.projectronin.rest.contract.support") version "1.2.0"
}

val v1 by configurations.creating

dependencies {
    v1("com.projectronin.fhir:common-fhir-r4-models:1.0.0")
}

`rest-contract-support` {
    disableLinting.set(true)
}
