<script setup>
import MenuOptionItem from './AdminSettingItem.vue'
</script>

<template>
  <div class="admin_view">

    <div class="title-div">
      <h2 class="title-text">Admin Settings</h2>
    </div>

    <MenuOptionItem>
      <template #heading>Lock Machine</template>
    </MenuOptionItem>

    <MenuOptionItem>
      <template #heading>Add User</template>
    </MenuOptionItem>

    <MenuOptionItem>
      <template #heading>Remove User</template>
    </MenuOptionItem>

    <MenuOptionItem>
      <template #heading>Change Liquid</template>
    </MenuOptionItem>

  </div>

  <div class="hide_admin_view">

    <div class="title-div">
      <h2 class="title-text">Restricted: Missing Admin Permissions</h2>
    </div>

  </div>

</template>


<script>
  import AccountRepository from '../../js/account-repo';
  //import FirebaseRepository from '../../js/firebase-repo';

  let accountRepo = new AccountRepository()
  //let firebaseRepo = new FirebaseRepository()

  export default {
    name: "AdminSettings",

    data() {
      return {
        hideAdminSettings: Boolean
      }
    },

    
    created() {
      console.log("AdminSettings Page Created");

      this.getActiveAccount();

      //console.log("Active Acc = "+this.hideAdminSettings);

    },

    computed: {

      cssVars() {
        return {
          '--user_admin': this.hideAdminSettings? "visible" : "hidden",
          '--user_not_admin': this.hideAdminSettings? "hidden" : "visible",
        }
      }
    },

    methods: {
  
      async getActiveAccount() {
      
        await accountRepo.getActiveAccount()
        .then( (response) => this.setActive(response.usertype) );
      },


      setActive(val) {

        console.log("The Value = "+val);

        if (val == "admin") {
          console.log("User is Admin");
          this.hideAdminSettings = false;
        } else {
          console.log("User is Not Admin");
          this.hideAdminSettings = true;
        }

        console.log(this.cssVars);

      }

    }

  }

</script>


<style scoped>

.title-div {
  text-align: center;
  background-color: #CCCCCC;
}

.title-text {
  font-size: 3rem;
  font-weight: 600;
  margin-bottom: 0.4rem;
  color: var(--color-heading);
}

.admin_view {
  visibility: var(--user_admin);
}

.hide_admin_view {
  visibility: hidden;
  /* visibility: var(--user_not_admin); */
}

</style>