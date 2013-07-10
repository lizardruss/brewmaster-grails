package org.brewmaster.utils

import liquibase.Liquibase
import liquibase.database.Database

class MigrationCallbacks {

    def searchableService;

    void beforeStartMigration(Database Database) {
    }

    void onStartMigration(Database database, Liquibase liquibase, String changelogName) {
    }

    void afterMigrations(Database Database) {
        // Manually start the mirroring process to ensure that it
        // comes after the automated migrations.
        println "Performing bulk index"
        searchableService.reindex()
        println "Starting mirror service"
        searchableService.startMirroring()
    }
}