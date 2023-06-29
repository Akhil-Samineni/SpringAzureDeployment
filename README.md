# SpringAzureDeployment
This Springboot App helps us connect to mongo db and retrieve data .
In order to connect to mongo db we get credentials from azure keyvault (We do get credentials from azure using DefaultAzureCrdential method)
And we did provide authentication and authorization using oAuth2 Azure Active Directory and also add resource server config to protect our api resources 

Once done we did deploy to Azure Spring App

In Azure 
  We need to create Azure App registration and configure redirect url 
  We need to creeate Azure KeyVault and grant us keyvault administrator to add secrets 
  We need to provide access to our from Azure key vault



  
