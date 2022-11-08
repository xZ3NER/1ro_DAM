package SourceCode.model.classes;

public class Food {

    private java.lang.String productCode;
    private java.lang.String productPrice;
    private java.lang.String productIngredients;
    private java.lang.String productName;
    private java.lang.String categoryCode;

    public Food(java.lang.String id, java.lang.String name, java.lang.String price, java.lang.String productIngredients , java.lang.String category) {
        this.productCode = id;
        this.productPrice = price;
        this.productName = name;
        this.productIngredients = productIngredients;
        this.categoryCode = category;

        categoryToCode();
    }

    private void categoryToCode() {
        switch (categoryCode) {
            case "Bebida": categoryCode="1";
            break;
            case "PlatoPrincipal": categoryCode="2";
                break;
            case "Entrante": categoryCode="3";
                break;
            case "Postre": categoryCode="4";
                break;
            default: categoryCode = "NULL";
        }
    }

    public java.lang.String getProductCode() {
        return productCode;
    }

    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }

    public java.lang.String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(java.lang.String productPrice) {
        this.productPrice = productPrice;
    }

    public java.lang.String getProductIngredients() {
        return productIngredients;
    }

    public void setProductIngredients(java.lang.String productIngredients) {
        this.productIngredients = productIngredients;
    }

    public java.lang.String getProductName() {
        return productName;
    }

    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }

    public java.lang.String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(java.lang.String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
