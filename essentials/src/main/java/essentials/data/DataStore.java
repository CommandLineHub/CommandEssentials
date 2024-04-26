/**
 * Command Line Hub
 * Essentials Core Library
 * 
 * By Sam Wilcox <sam@cmdlinehub.org>
 * https://www.cmdlinehub.org
 * 
 * View the user-end license agreement at:
 * https://license.cmdlinehub.org
 */

package essentials.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Data storage component class.
 * @package essentials.data
 */
public class DataStore {
    /**
     * Map that stores generic object data in the store.
     * @var Map<String, Object>
     */
    private Map<String, Object> data = new HashMap<>();

    /**
     * Map that stores string data in the store.
     * @var Map<String, String>
     */
    private Map<String, String> stringData = new HashMap<>();

    /**
     * Map that stores integer data in the store.
     * @var Map<String, Integer>
     */
    private Map<String, Integer> intData = new HashMap<>();

    /**
     * Map that stores double data in the store.
     * @var Map<String, Double>
     */
    private Map<String, Double> doubleData = new HashMap<>();

    /**
     * Map that stores float data in the store.
     * @var Map<String, Float>
     */
    private Map<String, Float> floatData = new HashMap<>();

    /**
     * Map that stores boolean data in the store.
     * @var Map<String, Boolean>
     */
    private Map<String, Boolean> boolData = new HashMap<>();

    /**
     * Sets the given key value pair into the data store.
     * @param key the key name
     * @param value the value to store for the given key
     */
    public void set(String key, Object value) {
        if (value instanceof Object) {
            this.data.put(key, value);
        } else if (value instanceof String) {
            this.stringData.put(key, (String) value);
        } else if (value instanceof Integer) {
            this.intData.put(key, (int) value);
        } else if (value instanceof Double) {
            this.doubleData.put(key, (double) value);
        } else if (value instanceof Float) {
            this.floatData.put(key, (float) value);
        } else if (value instanceof Boolean) {
            this.boolData.put(key, (Boolean) value);
        }
    }

    /**
     * Returns the given key value.
     * @param key the key name
     * @return the value of the key (null if key does not exist)
     */
    public Object get(String key) {
        if (this.exists(key)) return this.data.get(key);
        return null;
    }

    /**
     * Returns the given key value.
     * @param key the key name
     * @return the value of the key (null if key does not exist)
     */
    public String getString(String key) {
        if (this.exists(key)) return this.stringData.get(key);
        return null;
    }

    /**
     * Returns the given key value.
     * @param key the key name
     * @return the value of the key (null if key does not exist)
     */
    public int getInt(String key) {
        if (this.exists(key)) return this.intData.get(key);
        return -1;
    }

    /**
     * Returns the given key value.
     * @param key the key name
     * @return the value of the key (null if key does not exist)
     */
    public double getDouble(String key) {
        if (this.exists(key)) return this.doubleData.get(key);
        return -1;
    }

    /**
     * Returns the given key value.
     * @param key the key name
     * @return the value of the key (null if key does not exist)
     */
    public float getFloat(String key) {
        if (this.exists(key)) return this.floatData.get(key);
        return -1;
    }

    /**
     * Returns the given key value.
     * @param key the key name
     * @return the value of the key (null if key does not exist)
     */
    public Boolean getBoolean(String key) {
        if (this.exists(key)) return this.boolData.get(key);
        return null;
    }

    /**
     * Returns whether the given key exists in the data store.
     * @param key the key name
     * @return true if key exists in data store; false otherwise
     */
    public boolean exists(String key) {
        boolean exists = false;

        if (this.data.containsKey(key)) {
            exists = true;
        } else if (this.stringData.containsKey(key)) {
            exists = true;
        } else if (this.intData.containsKey(key)) {
            exists = true;
        } else if (this.doubleData.containsKey(key)) {
            exists = true;
        } else if (this.floatData.containsKey(key)) {
            exists = true;
        } else if (this.boolData.containsKey(key)) {
            exists = true;
        }

        return exists;
    }

    /**
     * Returns the total size of the data store.
     * @return total size of data store
     */
    public int size() {
        return this.data.size() + this.stringData.size() + this.intData.size() + this.doubleData.size() + this.floatData.size() + this.boolData.size();
    }

    /**
     * Deletes the given key from the data store.
     * @param key the key name of the value to delete
     */
    public void delete(String key) {
        if (this.data.containsKey(key)) this.data.remove(key);
        if (this.stringData.containsKey(key)) this.stringData.remove(key);
        if (this.intData.containsKey(key)) this.intData.remove(key);
        if (this.doubleData.containsKey(key)) this.doubleData.remove(key);
        if (this.floatData.containsKey(key)) this.floatData.remove(key);
        if (this.boolData.containsKey(key)) this.boolData.remove(key);
    }

    /**
     * Retuns the entire data store mapping.
     * @return data store mapping
     */
    public Map<String, Object> getAll() {
        return this.data;
    }

    /**
     * Sets the entire data store mapping.
     * @param data the mapping to set
     */
    public void setAll(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * Retuns the entire data store mapping for strings.
     * @return data store mapping
     */
    public Map<String, String> getAllStrings() {
        return this.stringData;
    }

    /**
     * Sets the entire string data store mapping.
     * @param data the mapping to set
     */
    public void setAllStrings(Map<String, String> stringData) {
        this.stringData = stringData;
    }

    /**
     * Retuns the entire data store mapping for integers.
     * @return data store mapping
     */
    public Map<String, Integer> getAllInts() {
        return this.intData;
    }

    /**
     * Sets the entire integer data store mapping.
     * @param data the mapping to set
     */
    public void setAllInts(Map<String, Integer> intData) {
        this.intData = intData;
    }

    /**
     * Retuns the entire data store mapping for doubles.
     * @return data store mapping
     */
    public Map<String, Double> getAllDoubles() {
        return this.doubleData;
    }

    /**
     * Sets the entire double data store mapping.
     * @param data the mapping to set
     */
    public void setAllDoubles(Map<String, Double> doubleData) {
        this.doubleData = doubleData;
    }

    /**
     * Retuns the entire data store mapping for floats.
     * @return data store mapping
     */
    public Map<String, Float> getAllFloats() {
        return this.floatData;
    }

    /**
     * Sets the entire float data store mapping.
     * @param data the mapping to set
     */
    public void setAllFloats(Map<String, Float> floatData) {
        this.floatData = floatData;
    }

    /**
     * Retuns the entire data store mapping for booleans.
     * @return data store mapping
     */
    public Map<String, Boolean> getAllBooleans() {
        return this.boolData;
    }

    /**
     * Sets the entire boolean data store mapping.
     * @param data the mapping to set
     */
    public void setAllBooleans(Map<String, Boolean> boolData) {
        this.boolData = boolData;
    }
}
