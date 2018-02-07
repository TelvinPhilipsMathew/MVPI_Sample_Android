package com.example.telvinm.mvpisample.dataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseModel
{
    @SerializedName("UserId")
    @Expose
    private Integer userId;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Type")
    @Expose
    private Integer type;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("CreatedBy")
    @Expose
    private Integer createdBy;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;
    @SerializedName("ModifiedBy")
    @Expose
    private Integer modifiedBy;
    @SerializedName("ModifiedDate")
    @Expose
    private String modifiedDate;
    @SerializedName("IsFirstLogin")
    @Expose
    private Integer isFirstLogin;
    @SerializedName("LoginStatus")
    @Expose
    private String loginStatus;
    @SerializedName("Supplier")
    @Expose
    private Object supplier;
    @SerializedName("Salt")
    @Expose
    private String salt;
    @SerializedName("CartCount")
    @Expose
    private Integer cartCount;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("SupplierId")
    @Expose
    private Integer supplierId;
    @SerializedName("ClientId")
    @Expose
    private Integer clientId;
    @SerializedName("ClientName")
    @Expose
    private String clientName;
    @SerializedName("SupplierName")
    @Expose
    private String supplierName;
    @SerializedName("IsClientIncludeVAT")
    @Expose
    private Boolean isClientIncludeVAT;

    @SerializedName("AuthToken")
    @Expose
    private String authToken;

    @SerializedName("parentclientid")
    @Expose
    private Integer parentclientid;
    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(Boolean isActive)
    {
        this.isActive = isActive;
    }

    public Integer getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(String createdDate)
    {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate()
    {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }

    public Integer getIsFirstLogin()
    {
        return isFirstLogin;
    }

    public void setIsFirstLogin(Integer isFirstLogin)
    {
        this.isFirstLogin = isFirstLogin;
    }

    public String getLoginStatus()
    {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus)
    {
        this.loginStatus = loginStatus;
    }

    public Object getSupplier()
    {
        return supplier;
    }

    public void setSupplier(Object supplier)
    {
        this.supplier = supplier;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public Integer getCartCount()
    {
        return cartCount;
    }

    public void setCartCount(Integer cartCount)
    {
        this.cartCount = cartCount;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Integer getSupplierId()
    {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId)
    {
        this.supplierId = supplierId;
    }

    public Integer getClientId()
    {
        return clientId;
    }

    public void setClientId(Integer clientId)
    {
        this.clientId = clientId;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public String getSupplierName()
    {
        return supplierName;
    }

    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }

    public Boolean getIsClientIncludeVAT()
    {
        return isClientIncludeVAT;
    }

    public void setIsClientIncludeVAT(Boolean isClientIncludeVAT)
    {
        this.isClientIncludeVAT = isClientIncludeVAT;
    }

    public String getAuthToken()
    {
        return authToken;
    }

    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }

    public Integer getParentclientid()
    {
        return parentclientid;
    }

    public void setParentclientid(Integer parentclientid)
    {
        this.parentclientid = parentclientid;
    }
}
