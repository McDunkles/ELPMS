<template>
    <div class="item">
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
    name: "MenuOptionItem",
  
    props: {
      option: String
    },
  
    data() {
      return {

      }
    },
  
    created() {
      //console.log("Ayooo my name is "+this.option)
    },
  
    mounted() {
  
    },
  
    methods: {
  
      onclick() {
        
        console.log("Menu Option Name = "+this.option);

        let newPath = "/";
        if (this.option == "settings") {
          newPath = "/settings"
        } else if (this.option == "make") {
          newPath = "/make"
        } else {
          newPath = "/viewLiquidLevels"
        }

        this.$router.push({path: newPath});
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
  