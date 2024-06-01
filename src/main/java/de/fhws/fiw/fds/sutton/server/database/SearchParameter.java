package de.fhws.fiw.fds.sutton.server.database;

/**
 * The SearchParameter class provides the required attributes to apply the paging behavior using offset and size.
 * It could also be used to define sorting criteria to sort the results that were read from the database,
 * and filtering criteria to narrow down the search results.
 */
public class SearchParameter {

    public static final SearchParameter DEFAULT = new SearchParameter();

    /**
     * The offset {@link Integer} from the collection of the full results where the page should start
     */
    private int offset = 0;

    /**
     * The size {@link Integer} of the page
     */
    private int size = Integer.MAX_VALUE;

    /**
     * The sorting criterion {@link String} to be used to sort the results from the database
     */
    private String orderByAttribute = "";

    /**
     * Additional filtering criteria
     */
    private String universityName = null;
    private String country = null;
    private String moduleName = null;
    private Integer semester = null;

    // Getters and Setters

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getOrderByAttribute() {
        return this.orderByAttribute;
    }

    public void setOrderByAttribute(String orderByAttribute) {
        this.orderByAttribute = orderByAttribute;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public boolean isAscending() {
        return true; // Assuming ascending order by default
    }
}