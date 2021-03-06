package com.webcrawler.spider;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;

import org.openqa.selenium.WebDriver;

import com.webcrawler.spider.interfaces.Crawlable;

/**
 * 
 * @author Sameer Gaware
 *
 */
public abstract class BaseSpider implements Crawlable{

	public static String NAME = null;
	protected String body = null;
	protected boolean  isTraversalPage = false;
	protected boolean isDataPage = false;
	protected boolean skipExtractLinkPhase = false;
	protected boolean setExtractLinkFromDataPage = false;
	protected Set<String> visitedLinks = null;
	protected Map<String,String> linkToCache = null;
	protected String startLink = null;
	protected ExecutorService executorService = null;
	protected volatile int cacheCount = 0;
	protected String path = "E:/web_crawler";
	protected String cacheDirectory = null;

	@Override
	public List<String> extractURLPhase(String url, String body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSkipExtractLinkPhase(boolean skipExtractLinkPhase) {
		this.skipExtractLinkPhase = skipExtractLinkPhase;

	}

	public File getCacheDirectory() {
		cacheDirectory = path+"/"+NAME; 
		return new File(cacheDirectory);
	}

	@Override
	public void setExtractLinkFromDataPage(boolean setExtractLinkFromDataPage) {
		this.setExtractLinkFromDataPage = setExtractLinkFromDataPage;

	}

	@Override
	public String normalizeURL(String url) {

		url = url.toLowerCase();
		return url;
	}
}
