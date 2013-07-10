import grails.util.Environment
import org.brewmaster.Hop
import org.brewmaster.HopUsage
import org.brewmaster.Malt
import org.brewmaster.Range
import org.brewmaster.Recipe

class BootStrap {

    def sessionFactory;

    def init = { servletContext ->

        switch (Environment.current.name) {
            case "development":
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
                dryHop.save();

                def bitteringHops = new HopUsage(
                        name: "Bittering Hops",
                        description: "Balances malt sweetness by adding hop bitterness.",
                        instructions: [
                                "Add hops early into the boil. Times and amounts will vary by recipe."
                        ]
                )
                bitteringHops.save();

                def aromaHops = new HopUsage(
                        name: "Aroma Hops",
                        description: "Late boil addition hops used to infuse hop aroma into the wort before fermentation.",
                        instructions: [
                                "Add hops late into the boil. Times and amounts will vary by recipe."
                        ]
                )
                aromaHops.save();

                def amarillo = new Hop(
                        name: "Amarillo",
                        description: "Citrusy hop, low yield, can be expensive.",
                        aroma:"Citrus",
                        uses:[bitteringHops, aromaHops, dryHop],
                        origin:"US",
                        alphaAcidRange: new Range(from:8.0, to:11.0)
                )
                amarillo.save()

                def cascade = new Hop(
                        name: "Cascade",
                        description: "Piney Hop from the northwest",
                        aroma:"Piney",
                        uses:[bitteringHops, aromaHops, dryHop],
                        origin:"US",
                        substitutes: [amarillo],
                        alphaAcidRange: new Range(from:4.5, to:7.0)
                )
                cascade.save()

                def northernBrewer = new Hop(
                        name: "Northern Brewer",
                        description: "Testing",
                        aroma:"Terrible",
                        uses:[bitteringHops],
                        origin:"US"
                )
                northernBrewer.save()

                def twoRow = new Malt(
                        name: "2-Row",
                        description: "Base Malt"
                )
                twoRow.save()

                def dadsIrishRed = new Recipe(
                        name: "Dad's Irish Red",
                        description: "Malty Irish Red",
//                        hops: [northernBrewer],
                        malts: [twoRow]
                )
                dadsIrishRed.save()
                break
        }
    }

    def destroy = {
    }
}
