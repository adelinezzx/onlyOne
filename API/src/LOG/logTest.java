package LOG;

import org.apache.log4j.Logger;

public class logTest {
	private static Logger LOG = Logger.getLogger(logDemo.class);
    public void fun(){
	    LOG.debug("debug文件");
		LOG.info("info文件");
        LOG.warn("warn文件");
        LOG.error("error文件");
   }
}
