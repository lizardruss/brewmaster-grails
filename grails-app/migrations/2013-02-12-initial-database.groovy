databaseChangeLog = {

    changeSet(author: "t-mobile (generated)", id: "1360700763823-1") {
        addColumn(tableName: "hop") {
            column(name: "origin", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }
    changeSet(author: "t-mobile (generated)", id: "1360702450017-1") {
        addColumn(tableName: "hop") {
            column(name: "usage", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }
}
