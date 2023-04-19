import Keycloak from "keycloak-js";
//import AccountRepository from "../js/account-repo";

class AuthenticationUtil {

  async init(appInitCallback, errorCallback) {

    let providerUrl = "http://localhost:8080"
    let realm = "elpms-dev"
    
    //let accountRepo = new AccountRepository();

    this._keycloak = new Keycloak({
      url: providerUrl,
      realm: realm,
      clientId: "ELPMS"
    });

    //let username = "uh";

    let accountInfo = {
      username: "uh",
      isAdmin: false
    };

    this._keycloak.init({ onLoad: "login-required"}).then((authenticated) => {
      if (authenticated) {
        let accessData = this._keycloak.tokenParsed["realm_access"];
        //accountInfo.username = this._keycloak.tokenParsed["name"];
        accountInfo.username = this._keycloak.tokenParsed["preferred_username"];

        let resource_access = JSON.stringify(this._keycloak.tokenParsed["resource_access"]);
        //resource_access = this._keycloak.tokenParsed["resource_access"];

        console.log(resource_access);

        //console.log(this._keycloak.tokenParsed["resource_access"]["elpms"]["roles"].indexOf("AdminUser"));

        //accountInfo.isAdmin = (this._keycloak.tokenParsed["resource_access"]["elpms"]["roles"].indexOf("AdminUser") != -1);
        //console.log(JSON.stringify(accountInfo));

        let userType = "user";
        if (accountInfo.isAdmin) {userType="admin";}

        let reqBody = {
          username: accountInfo.username,
          usertype: userType
        }

        //this.addAccount(accountRepo, reqBody);

        //accountRepo.activeAccountId = 3;

        //console.log("At auth: account = "+accountRepo.getActiveAccountId());

        console.log("Account Login Information: "+JSON.stringify(this._keycloak.tokenParsed));
        window.appAuth = {
          name: this._keycloak.tokenParsed["name"],
          accessToken: this._keycloak.token,
          isAdmin: accessData && accessData.roles && 
                  accessData.roles.includes("ELPMSUser") 
        };
        appInitCallback();
      } else {
        window.location.reload();
      }
    
    }).catch((e) => {
      //TODO: propagate error status to UI
      console.error("Authentication initialization failure");
      errorCallback(e);
    });


    //let username = JSON.stringify(this._keycloak);
    console.log("Da Username = "+accountInfo.username);


    this._keycloak.onTokenExpired = () => {

      this._keycloak.updateToken(30).then(refreshed => {
        if (refreshed) {
          window.appAuth.accessToken = this._keycloak.token;
          console.log("Token was successfully refreshed");
        } else {
          console.log("Token is still valid");
        }
      }).error((e) => {
        //TODO: propagate error status to UI
        console.error('Failed to refresh the token, or the session has expired');
      });

    }

  }


  /*
  async addAccount(accountRepo, requestBody) {
    
    let res = await accountRepo.addAccount(requestBody)
    .then( (response) => console.log(JSON.stringify(response)) ); 

    //let res2 = await liquidContainerMappingRepo.findByContainerNo(searchParam)
    //.then( (response) => this.liquid_info = response ); 

  }
  */


  logout() {
    this._keycloak.logout();
    console.log("Logged out");
  }

}


export default new AuthenticationUtil();