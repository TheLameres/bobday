package thelameres.bobday.client.targets;

import feign.Target;
import thelameres.bobday.client.feign.BobdayClient;

public class BobdayClientTarget extends Target.HardCodedTarget<BobdayClient> {
    public BobdayClientTarget(Class<BobdayClient> clazz, String name, String url) {
        super(clazz, name, url);
    }
}
