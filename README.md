# EHR Data Authority REST API Contract

This repo contains the contract for the EHR Data Authority REST API.

## FHIR Version

This contract relies on the schemas defined
by [common-fhir-r4-models](https://github.com/projectronin/ronin-fhir-models/tree/main/common-fhir-r4-models). If the
version is updated, you should run the following to ensure the proper schemas are loaded:
```./gradlew copySchema```

## Running

In general, either run:

`./gradlew <COMMAND> <ARGUMENTS>`

(requires JDK 11+ and node 16+ installed and working)

or

`./contract-tools <COMMAND> <ARGUMENTS>`

(requires: docker desktop or equivalent)

The two should be equivalent with the exception that the `contract-tools` script runs the gradle build inside a docker
container.

Available commands are mostly general gradle commands. Important or unusual ones are:

`incrementApiVersion [-Psnapshot=true|false] [-Pversion-increment=MINOR|PATCH|NONE]`: Increments the semantic versions
of all API versions. Optional
arguments determine if the tool puts a `-SNAPSHOT` on the end of thew version and what level of incrementing takes
place. Level `NONE` can be used to get
the tooling to remove an existing `-SNAPSHOT` suffix without making other changes. The tool will _also_ make sure that
the semantic version in each directory
matches the directory's major version number.

`check`: Verifies the contract using spectral tooling, making sure it's a valid contract.

`downloadApiDependencies`: downloads any API dependencies as specified in the `Dependencies` section above.

`build`: Runs `check`, generates schema documentation, and generates simple combined schema files.

`clean`: removes all generated files

`assemble`: Assembles the schema into deployable archives.

`publishToMavenLocal`: publishes all outputs to the local maven repo (e.g. `$HOME/.m2/repository`). If you are using the
docker image, it will try and
copy files in and out of the host's repository directory so they can be used for builds later on the host.

`publish`: publishes all outputs to the remote Ronin maven repository.

## Plugin Help

Please see [ronin-contract-rest-tooling](https://github.com/projectronin/ronin-contract-rest-tooling) for more
information on the plugin and available options.
