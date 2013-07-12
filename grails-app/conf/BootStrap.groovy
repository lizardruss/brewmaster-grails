import grails.util.Environment
import org.brewmaster.Brewer
import org.brewmaster.Hop
import org.brewmaster.HopUsage
import org.brewmaster.Malt
import org.brewmaster.Range
import org.brewmaster.Recipe
import org.brewmaster.Role
import org.brewmaster.UserRole

class BootStrap {

    def sessionFactory;

    def init = { servletContext ->

        switch (Environment.current.name) {
            case "development":

                def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
                def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

                def adminUser = Brewer.findByUsername('admin') ?: new Brewer(
                        username: 'admin',
                        password: 'admin',
                        enabled: true
                ).save(failOnError: true)

                if (!adminUser.authorities.contains(adminRole)) {
                    UserRole.create adminUser, adminRole
                }

                def user1 = Brewer.findByUsername('user1') ?: new Brewer(
                        username: 'user1',
                        password: 'user1',
                        enabled: true
                ).save(failOnError: true)

                if (!user1.authorities.contains(adminRole)) {
                    UserRole.create user1, userRole
                }


                def dryHop = new HopUsage(
                        name: "Dry Hop",
                        description: "Infuses hop flavor and aroma into the beer.",
                        instructions: [
                                "Clean and sanitize a carboy.",
                                "Add pellet hops through the neck of the carboy.",
                                "Rack beer onto hops.",
                                "Replace airlock and sample beer each day until the desired level of hop aroma and flavor is reached."
                        ]
                )
                dryHop.save(failOnError: true);

                def bitteringHops = new HopUsage(
                        name: "Bittering Hops",
                        description: "Balances malt sweetness by adding hop bitterness.",
                        instructions: [
                                "Add hops early into the boil. Times and amounts will vary by recipe."
                        ]
                )
                bitteringHops.save(failOnError: true);

                def aromaHops = new HopUsage(
                        name: "Aroma Hops",
                        description: "Late boil addition hops used to infuse hop aroma into the wort before fermentation.",
                        instructions: [
                                "Add hops late into the boil. Times and amounts will vary by recipe."
                        ]
                )
                aromaHops.save(failOnError: true);

                def amarillo = new Hop(
                        name: "Amarillo",
                        description: "Citrusy hop, low yield, can be expensive.",
                        aroma:"Citrus",
                        uses:[bitteringHops, aromaHops, dryHop],
                        origin:"US",
                        alphaAcidRange: new Range(from:8.0, to:11.0)
                )
                amarillo.save(failOnError: true)

                def cascade = new Hop(
                        name: "Cascade",
                        description: "Piney Hop from the northwest",
                        aroma:"Piney",
                        uses:[bitteringHops, aromaHops, dryHop],
                        origin:"US",
                        substitutes: [amarillo],
                        alphaAcidRange: new Range(from:4.5, to:7.0)
                )
                cascade.save(failOnError: true)

                def northernBrewer = new Hop(
                        name: "Northern Brewer",
                        description: "Testing",
                        aroma:"Terrible",
                        uses:[bitteringHops],
                        origin:"US",
                        substitutes: [],
                        alphaAcidRange: new Range(from:4.5, to:7.0)
                )
                northernBrewer.save(failOnError: true)

                def twoRow = new Malt(
                        name: "2-Row",
                        description: "Base Malt"
                )
                twoRow.save(failOnError: true)

                def dadsIrishRed = new Recipe(
                        name: "Dad's Irish Red",
                        description: "Malty Irish Red",
                        hops: [northernBrewer],
                        malts: [twoRow]
                )
                dadsIrishRed.save(failOnError: true);
                break;
        }
    }

    def destroy = {
    }
}
