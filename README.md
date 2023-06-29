# SpringAzureDeployment
This Springboot App helps us connect to mongo db and retrieve data .
In order to connect to mongo db we get credentials from azure keyvault (We do get credentials from azure using DefaultAzureCrdential method)
And we did provide authentication and authorization using oAuth2 Azure Active Directory and also add resource server config to protect our api resources 

Once done we did deploy to Azure Spring App

In Azure 
  We need to create Azure App registration and configure redirect url 
  We need to creeate Azure KeyVault and grant us keyvault administrator to add secrets 
  We need to provide access to our App from Azure key vault

Azure deploy commands
  
  az spring app create --name APPNAME --runtime-version Java_17 --instance-count 1 --memory 2Gi --assign-endpoint
  maven build 
  az spring app deploy --name APPNAME --artifact-path target/azure-0.0.1-SNAPSHOT.jar --jvm-options="-Xms2048m -Xmx2048m"
  
 Issues faced :
	App failed to start saying that it was unable to get secrets with error unauthorized
	
		Error message:
			
		Caused by: com.azure.core.exception.HttpResponseException: Status code 403, "{"error":{"code":"Forbidden","message":"Caller is not authorized to perform actio
		n on resource.\r\nIf role assignments, deny assignments or role definitions were changed recently, please observe propagation time.\r\nCaller: appid=6f9dce08-
		500c-44b0-9670-309c358201c0;oid=5fde8331-374a-4550-b1fa-b2bc8eb86a7c;iss=https://sts.windows.net/da427fed-0866-4706-809a-9d39896ddf3d/\r\nAction: 'Microsoft.K
		eyVault/vaults/secrets/readMetadata/action'\r\nResource: '/subscriptions/ddef9bf9-11a6-4312-b654-31844030ad8a/resourcegroups/akhil-new-azure-resource-group/pr
		oviders/microsoft.keyvault/vaults/akhil-mongodb-vault'\r\nAssignment: (not found)\r\nDecisionReason: 'DeniedWithNoValidRBAC' \r\nVault: akhil-mongodb-vault;lo
		cation=eastus\r\n","innererror":{"code":"ForbiddenByRbac"}}}"
		
		Resolved by making azure keyvault and spring app using same resource group
		on azure key vault under access configuration we need to enable Azure role-based access control (recommended)
		on azure key vault under IAM we need to give reader access to APP registered in Active Directory
		on spring app we need to create an identity and assign reader access to key vault 
		
	App started but unable to connect to mongoDB 
		Reason for this mongoDB is restricting connections from any external network
		for this we need to get IP addresses of our spring app and then allow access in mongoDB
		
		we can find IP address of Spring app under networking
		In mongoDB under SECURITY in network access we need to IP address of spring APP

		

