<template>
    <div class="item" :style="cssVars">
    <!-- <div class="item"> -->
      <div class="menu-option" v-on:click="this.onclick();">
        <h2>
          <slot name="heading"></slot>
        </h2>
        <slot></slot>
      </div>
    </div>
  </template>
  
  
  <script>
  
    export default {
      name: "InventoryItem",
  
      props: {
        item_name: String
      },
  
      data() {
        return {
            selected: Boolean
        }
      },
  
      created() {
        console.log("InventoryItem Created!");
        this.selected = false;
      },
  
      mounted() {
  
      },
  
      computed: {
        cssVars() {
  
          let bkg_colour = "EEEEEE";
  
          if (this.selected) {
            bkg_colour = "A9A9A9";
          }
  
          return {
            'background-color': '#' + bkg_colour,
          }
        }
      },
  
      methods: {
  
        onclick() {
          
          console.log("MakeDrinkItem Clicked! Name = "+this.item_name);
          this.selected = !this.selected;
        }
  
      }
    }
  </script>
  
  <style scoped>
  .item {
    margin-top: 2rem;
    display: flex;
  }
  
  .menu-option {
    flex: 1;
    text-align: center;
  }
  
  
  h2 {
    font-size: 2rem;
    font-weight: 500;
    margin-bottom: 0.4rem;
    color: var(--color-heading);
  }
  
  h2:hover {
    color: gray;
    /* border: 1px solid #000000 */
  }
  
  </style>