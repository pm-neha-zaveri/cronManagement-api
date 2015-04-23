package cronmanagement.utility;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

public class CacheUtil {
	
	private static CacheManager cacheManager;

	@Autowired
	public CacheUtil(CacheManager cacheManager) {
		CacheUtil.cacheManager = cacheManager;
	}
	
	public static Cache getCache(String cacheName) {
		return cacheManager.getCache(cacheName);
	}

	public static Object get(String cacheName, Object key) {
		Object value = null;
		Cache cache = cacheManager.getCache(cacheName);
		if(cache!=null){
			ValueWrapper valueWrapper = cache.get(key);
			if(valueWrapper!=null){
				value = valueWrapper.get();
			}
		}
		return value;
	}

	public static boolean put(String cacheName, Object key, Object value) {
		boolean isCached = false;
		Cache cache = cacheManager.getCache(cacheName);
		if(cache!=null){
			cache.put(key, value);
			isCached = true;
		}
		return isCached;		
	}
	
	public static boolean evict(String cacheName, Object key){
		boolean isEvicted = false;
		Cache cache = cacheManager.getCache(cacheName);
		if(cache!=null){
			cache.evict(key);;
			isEvicted = true;
		}
		return isEvicted;
	}
	
	public static boolean clear(String cacheName) {
		boolean isCleared = false;
		Cache cache = cacheManager.getCache(cacheName);
		if(cache!=null){
			cache.clear();
			isCleared = true;
		}
		return isCleared;
	}
	
}