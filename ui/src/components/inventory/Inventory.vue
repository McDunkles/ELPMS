<script setup>
import InventoryItem from './InventoryItem.vue'
</script>

<template>

  <h3 class="modify" v-on:click="this.add_item();">Add Item</h3>

  <div class="title-div">
    <h2 class="title-text">Inventory</h2>
  </div>

  <div v-for="elem in items">
    <InventoryItem :item_name=elem.name v-on:click="this.on_click(elem);">
      <template #heading>{{elem.name}}</template>
    </InventoryItem>
  </div>

</template>


<script>
  import ItemRepository from '../../js/item-repo'

  let itemRepo = new ItemRepository()

  export default {
    name: "Inventory",

    props: {

    },

    data() {
      return {
        items: String,
        selected_item: Object
      }
    },

    created() {
      console.log("Inventory Component Created");

      this.getItems();

      console.log("items = "+this.items);

    },

    mounted() {

    },

    computed: {

    },

    methods: {
  
      async getItems() {

        let res = await itemRepo.findAll()
        .then( (response) => this.items = response ); 
      },

      async getItem(params) {

        let res = await itemRepo.find(params)
        .then( (response) => this.items = response ); 
      },

      add_item() {
        console.log("Add Item!");

        let newPath = "/inventory/addItem"
        this.$router.push({path: newPath});
      },

      on_click(item) {
        console.log("Been clicked!");

        this.selected_item = item;

        console.log(JSON.stringify(item));

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


h3 {
width: 100%;
display: inline-block;
text-align: end;
}

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

</style>