<script setup>

</script>

<template>
    <main class="content">

        <h2 class="title">Add An Item</h2>

        <div class = "div-input">
            <label label="ItemId">Item Id </label>
            <input v-model="item_id"/>
        </div>

        <div class = "div-input">
            <label label="ItemName">Item Name </label>
            <input v-model="item_name"/>
        </div>

        <div class = div-input>
            <button class="save-button" v-on:click="this.add_item();">Add Item</button>
        </div>

    </main>
</template>

<script>

  import UrlUtils from "../../js/url-utils"
  import ItemRepository from "../../js/item-repo"

  export default {
    name: "AddItem",
  
    props: {
    },
  
    data() {
      return {
        item_id: -1,
        item_name: ''
      }
    },
  
    created() {
      console.log("AddItem Component Created");


    },
  
    mounted() {
  
    },

    computed: {
        
    },
  
    methods: {
  
        get_request_params() {

            let params = {
                id: this.item_id,
                name: this.item_name,
                available: true
            };

            return params;
        },

        to_url_format() {

            let params = {
                id: this.item_id,
                name: this.item_name,
                available: true
            };

            return UrlUtils.toUrlEncoded(params);
        },

        async add_item_async() {

            console.log("URL FORMAT = "+this.to_url_format());

            let params = this.get_request_params();

            let itemRepo = new ItemRepository();

            let resp = await itemRepo.addItem(params)
            .then( (response) => console.log("Response = "+JSON.stringify(response)) );

        },

        add_item() {
            this.add_item_async();

            this.$router.push("/inventory");
        }
    }
  }

</script>

<style scoped>
h2 {

    margin-top: 2rem;
    flex: 1;
    text-align: center;
  
    font-size: 2.5rem;
    font-weight: 600;
    margin-bottom: 0.4rem;
    color: var(--color-heading);
  }

.title {
    margin-bottom: 2rem;
}

.div-input {
    margin-top: 0.25rem;
    align-content: center;
    text-align: center;
}

.step-label {
    margin-top: 1rem;
}

label {
    margin-right: 0.5rem;
}

input {
    margin-right: 3rem;
}

.save-button {
    margin-top: 2rem;
}

</style>

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

.content {
  background-color: #DDDDDD;
  vertical-align: top;
  height: 100%;
  display: inline-block;
  width: 750px;
}

</style>